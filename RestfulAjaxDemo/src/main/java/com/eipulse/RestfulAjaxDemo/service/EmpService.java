package com.eipulse.RestfulAjaxDemo.service;

import java.util.List;

import com.eipulse.RestfulAjaxDemo.entitys.Employee;

public interface EmpService {
	Employee saveEmp(Employee employee);

	Employee findEmpById(Integer empId);

	List<Employee> findEmpAll();

	boolean updateEmp(Integer empId, Employee employee);

	boolean deleteEmp(Integer empId);
}
