package com.eipulse.RestfulAjaxDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eipulse.RestfulAjaxDemo.entitys.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query(value = "from Login  l where l.employee.email= ?1")
	Optional<Login> findByEmail(String email);
}
