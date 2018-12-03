package com.apps.restspringboot.User;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details on user")
public class User {

	
	private Integer id;
	
	@Size(min=2,message="Name must be atleast 2 characters ")
	@ApiModelProperty(notes="Name must be atleast 2 characters ")

	private String name;
	
	@Past(message="DOB should not be in future ")
	
	@ApiModelProperty(notes="Birth date should be in  the past ")
	private Date dob;

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

	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	

}
