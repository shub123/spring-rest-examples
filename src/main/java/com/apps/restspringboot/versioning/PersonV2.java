package com.apps.restspringboot.versioning;

public class PersonV2 {

	private String name;
	private String lastName;

	public PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public PersonV2(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
