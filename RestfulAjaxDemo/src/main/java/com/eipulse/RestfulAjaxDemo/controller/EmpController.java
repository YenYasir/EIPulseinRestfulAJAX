package com.eipulse.RestfulAjaxDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eipulse.RestfulAjaxDemo.entitys.Employee;
import com.eipulse.RestfulAjaxDemo.service.EmpServiceImp;

@RestController
public class EmpController {

	private EmpServiceImp empServiceImp;

	@Autowired
	public EmpController(EmpServiceImp empServiceImp) {
		this.empServiceImp = empServiceImp;
	}

	@PostMapping("/employee/post")
	public Employee postNewEmployeePage(@RequestBody Employee newEmployee) {
		return empServiceImp.saveEmp(newEmployee);
	}

	@GetMapping("/employee")
	public List<Employee> findAllEmp() {
		List<Employee> employees = empServiceImp.findEmpAll();
		if (employees != null) {
			return employees;
		}
		return null;
	}

	// OK
	@GetMapping("/employee/{empId}")
	public Employee findByIdEmp(@PathVariable Integer empId) {

		return empServiceImp.findEmpById(empId);
	}

	@GetMapping("/employee/editPage")
	public String editEmployeePage(@RequestParam("empId") Integer empId, Model model) {
		Employee employee = empServiceImp.findEmpById(empId);
		model.addAttribute("employee", employee);
		return "/employee/editPage";
	}

	@PutMapping("/employee/edit")
	public String editEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
		empServiceImp.updateEmp(newEmployee.getEmpId(), newEmployee);
		return "/employee/allEmp";
	}

	@DeleteMapping("/employee/deleteEmp")
	public String deleteEmployee(@RequestParam("empId") Integer empId) {
		empServiceImp.deleteEmp(empId);
		return "/employee/allEmp";
	}

}
