package com.apps.restspringboot;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String msg;

	public ExceptionResponse(Date timestamp, String msg, String details) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
		this.details = details;
	}

	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	private String details;

}
