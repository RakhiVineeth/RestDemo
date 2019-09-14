package com.rest.demo.restapi.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "Employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "first_name",nullable=false)
	private String firstName;
	@Column(name = "last_name",nullable=false)
	private String lastName;
	@Column(name = "email",nullable=false)
	private String email;
	@Column(name = "mobile_number",nullable=false)
	private String mobileNumber;
	private String jobTitle;
	private String StartDate;
	private int salary;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE )
	@JoinColumn(name ="department_id")
	private Department department;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
}
