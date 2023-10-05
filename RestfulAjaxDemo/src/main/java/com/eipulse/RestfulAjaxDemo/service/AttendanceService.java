package com.eipulse.RestfulAjaxDemo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.eipulse.RestfulAjaxDemo.entitys.Attendance;

public interface AttendanceService {
	Attendance updateAttendance(Integer empId, LocalDateTime startTime, LocalDateTime endTime);

	Attendance findByEmpIdLastAttendance(Integer empId);

	List<Attendance> findByEmpIdAllAttendance(Integer empId);

	List<Attendance> findAllEmpAttendance();
}
