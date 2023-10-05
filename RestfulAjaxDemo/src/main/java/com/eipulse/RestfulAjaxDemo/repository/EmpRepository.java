package com.eipulse.RestfulAjaxDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eipulse.RestfulAjaxDemo.entitys.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
