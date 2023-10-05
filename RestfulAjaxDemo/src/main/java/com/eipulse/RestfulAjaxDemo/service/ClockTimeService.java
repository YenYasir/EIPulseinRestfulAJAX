package com.eipulse.RestfulAjaxDemo.service;

import java.util.List;

import com.eipulse.RestfulAjaxDemo.dto.ClockTimeDTO;
import com.eipulse.RestfulAjaxDemo.entitys.ClockTime;

public interface ClockTimeService {
	ClockTime saveClockTime(Integer empId, String type, double latitude, double longitude);

	ClockTimeDTO findByEmpIdLastTime(Integer empId);

	List<ClockTimeDTO> findByEmpIdAllTime(Integer empId);

	List<ClockTimeDTO> findAllTime();

}
