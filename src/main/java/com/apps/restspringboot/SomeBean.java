package com.apps.restspringboot;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"a"})

@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String a;
	private String b;
	
	//@JsonIgnore
	
	//static filtering implemented 
	private String c;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public SomeBean(String a, String b, String c) {
		// TODO Auto-generated constructor stub
		this.a=a;
		this.b=b;
		this.c=c;
	}

	public SomeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
