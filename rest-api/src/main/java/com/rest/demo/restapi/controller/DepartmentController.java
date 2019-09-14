package com.rest.demo.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.restapi.exception.ResourceNotFoundException;
import com.rest.demo.restapi.model.Department;
import com.rest.demo.restapi.repository.DepartmentRepository;

@RestController
@RequestMapping("api/resources/v1/departments")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	@GetMapping("/")

	public List<Department> getAllDepartments()
	{
		//return departmentRepository.findAll();
		return departmentRepository.findByOrderByDepartmentIdAsc();
		
	}
	@GetMapping("/{id}")
	  public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long DepartmentId) 
			  throws ResourceNotFoundException {
			
		//Department dpt = departmentRepository.findById(DepartmentId).orElseThrow()->new ResourceNotFoundException("Department not found on :"+DepartmentId);
		Department dpt = departmentRepository.findById(DepartmentId).orElseThrow(()->new ResourceNotFoundException("Department not found on :"+DepartmentId));
		return ResponseEntity.ok().body(dpt);
	  }
	@PostMapping("/")
	public Department createDepartment(@Valid @RequestBody Department dpt)
	{
		return departmentRepository.save(dpt);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateeDepartment(@PathVariable(value="id") Long DepartmentId,@Valid @RequestBody Department DepartmentDetails) throws ResourceNotFoundException
	{
		Department dpt = departmentRepository.findById(DepartmentId).orElseThrow(()->new ResourceNotFoundException("Department not found on :"+DepartmentId));
		dpt.setName((DepartmentDetails.getName()));
		final Department updateddpt = departmentRepository.save(dpt);
		return ResponseEntity.ok(updateddpt);
		}
	@DeleteMapping("/{id}")
	public Map<String, Boolean>deleteDepartment(@PathVariable(value="id")Long DepartmentId) throws ResourceNotFoundException
	{
		Department dpt = departmentRepository.findById(DepartmentId).orElseThrow(()->new ResourceNotFoundException("Department not found on :"+DepartmentId));
		departmentRepository.delete(dpt);
		Map<String, Boolean> resp= new HashMap();
		resp.put("Deleted", Boolean.TRUE);
		return resp;
		

	}
	     
	

}
