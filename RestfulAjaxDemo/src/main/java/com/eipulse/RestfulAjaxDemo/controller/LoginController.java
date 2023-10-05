package com.eipulse.RestfulAjaxDemo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eipulse.RestfulAjaxDemo.dto.EmailDTO;
import com.eipulse.RestfulAjaxDemo.dto.LoginDTO;
import com.eipulse.RestfulAjaxDemo.dto.NewPasswordDTO;
import com.eipulse.RestfulAjaxDemo.entitys.Login;
import com.eipulse.RestfulAjaxDemo.repository.LoginRepository;
import com.eipulse.RestfulAjaxDemo.service.LoginServiceImp;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin(origins = "http://localhost:5173/")//cross
@RestController
public class LoginController {

	private LoginServiceImp loginServiceImp;
	private final LoginRepository loginRepository;

	@Autowired
	public LoginController(LoginServiceImp loginServiceImp, LoginRepository loginRepository) {
		this.loginServiceImp = loginServiceImp;
		this.loginRepository = loginRepository;
	}

//	@PostMapping("/login")
//	public ResponseEntity<?> loginCheck(@RequestBody LoginDTO requestLogin, HttpSession httpSession) {
//		System.out.println(requestLogin);
//		try {
//			Login login = loginServiceImp.checkLogin(requestLogin.getEmpId(), requestLogin.getPassword());
//			httpSession.setAttribute("empId", login.getEmpId());
//			System.out.println(login);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (UnsupportedOperationException e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//		}
//	}
	@PostMapping("/login")
	public ResponseEntity<?> loginCheck(@RequestBody LoginDTO requestLogin, HttpSession httpSession) {
		System.out.println(requestLogin);
		try {
			Login login = loginServiceImp.checkLogin(requestLogin.getEmpId(), requestLogin.getPassword());
			httpSession.setAttribute("empId", login.getEmpId());
			System.out.println(login);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/login/forgetPassword")
	public ResponseEntity<?> forgetPassword(@RequestBody EmailDTO requestEmail, HttpSession httpSession) {
		int otpVal = new Random().nextInt(999999);
		httpSession.setAttribute("mailOtp", otpVal);
		try {
			Login login = loginServiceImp.forgetPassword(requestEmail.getEmail(), otpVal);
			System.out.println(login);
			return new ResponseEntity<>(login.getEmpId(), HttpStatus.OK);
		} catch (UnsupportedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/login/newPassword")
	public ResponseEntity<?> otpCheck(@RequestBody NewPasswordDTO newPasswordDTO, HttpSession httpSession) {
		try {
			Integer mailOtp = (Integer) httpSession.getAttribute("mailOtp");
			Login login = loginRepository.findById(newPasswordDTO.getEmpId()).get();
			System.out.println(mailOtp);
			System.out.println(newPasswordDTO);
			if (mailOtp != null && mailOtp.equals(newPasswordDTO.getOtpCheck())) {
				System.out.println("OTP相同");
				loginServiceImp.newPassword(login, newPasswordDTO.getNewPassword());
			} else {
				System.out.println("OTP不同");

				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (UnsupportedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
}
