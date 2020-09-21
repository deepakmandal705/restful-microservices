package com.deepak.restfulmicroservices.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, message = "Name should have atleast 3 characters")
	private String name;
	
	@Past
	private Date dob;
	
	
	
	public UserEntity() {

	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
