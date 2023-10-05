package com.eipulse.RestfulAjaxDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eipulse.RestfulAjaxDemo.entitys.OfficeRegions;

public interface OfficeRegionsRepository extends JpaRepository<OfficeRegions, Integer> {
//    likeSearch分公司名
	List<OfficeRegions> findByRegionsNameLike(String name);
}