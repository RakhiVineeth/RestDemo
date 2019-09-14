package com.rest.demo.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.demo.restapi.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	List<Department> findByOrderByDepartmentIdAsc();

}
