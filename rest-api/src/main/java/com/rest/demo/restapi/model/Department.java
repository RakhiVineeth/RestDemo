package com.rest.demo.restapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Department",uniqueConstraints=@UniqueConstraint(columnNames="name"))
//@EntityListeners(AuditingEntityListener.class)


public class Department  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentId;
	@Column(name = "name",nullable = false)
	private String name;
	

	//@OneToMany(mappedBy = "department",targetEntity = Employee.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	

	//private List employeeList;
	
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
