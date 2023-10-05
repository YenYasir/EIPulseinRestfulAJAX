package com.eipulse.RestfulAjaxDemo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eipulse.RestfulAjaxDemo.entitys.Attendance;
import com.eipulse.RestfulAjaxDemo.entitys.Employee;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

//    顯示員工選擇日期的當日出勤時數狀況
	Optional<Attendance> findByDateAndEmployee(LocalDate date, Employee employee);

}