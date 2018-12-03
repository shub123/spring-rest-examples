package com.apps.restspringboot.Post;

import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	public PostNotFoundException(String msg) {
		// TODO Auto-generated constructor stub

		super(msg);

	}

}
