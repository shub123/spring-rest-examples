package com.apps.restspringboot.User;

import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		
		 super(msg);
		
	}

}
