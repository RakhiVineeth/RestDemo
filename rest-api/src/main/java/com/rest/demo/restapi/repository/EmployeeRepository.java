package com.rest.demo.restapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.demo.restapi.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.department.departmentId  = :id")
    List<Employee> findByDepartmentId(@Param("id") Long id);	

}
