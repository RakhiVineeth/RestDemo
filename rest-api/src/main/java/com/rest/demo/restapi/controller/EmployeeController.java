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

import com.rest.demo.restapi.*;
import com.rest.demo.restapi.exception.ResourceNotFoundException;
import com.rest.demo.restapi.model.Employee;
import com.rest.demo.restapi.repository.EmployeeRepository;

@RestController
@RequestMapping("api/resources/v1/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	@GetMapping("/")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
		
	}
	@GetMapping("/{id}")
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) 
			  throws ResourceNotFoundException {
			
		//Employee emp = employeeRepository.findById(employeeId).orElseThrow()->new ResourceNotFoundException("Employee not found on :"+employeeId);
		Employee emp = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found on :"+employeeId));
		return ResponseEntity.ok().body(emp);
	  }
	@GetMapping("department/{id}")
	public List<Employee> getDepartmentEmployeeById(@PathVariable(value = "id") Long departmentId) 
			  throws ResourceNotFoundException {
			
		//Employee emp = employeeRepository.findById(employeeId).orElseThrow()->new ResourceNotFoundException("Employee not found on :"+employeeId);
		return employeeRepository.findByDepartmentId(departmentId);
	  }
	
	@PostMapping("/")
	public Employee createEmployee(@Valid @RequestBody Employee emp)
	{

		return employeeRepository.save(emp);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateeEmployee(@PathVariable(value="id") Long employeeId,@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException
	{
		Employee emp = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found on :"+employeeId));
		emp.setEmail(employeeDetails.getEmail());
		emp.setFirstName(employeeDetails.getFirstName());
		emp.setLastName(employeeDetails.getLastName());
		final Employee updatedEmp = employeeRepository.save(emp);
		return ResponseEntity.ok(updatedEmp);
		}
	@DeleteMapping("/{id}")
	public Map<String, Boolean>deleteEmployee(@PathVariable(value="id")Long employeeId) throws ResourceNotFoundException
	{
		Employee emp = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found on :"+employeeId));
		employeeRepository.delete(emp);
		Map<String, Boolean> resp= new HashMap();
		resp.put("Deleted", Boolean.TRUE);
		return resp;
		

	}
	     
}
