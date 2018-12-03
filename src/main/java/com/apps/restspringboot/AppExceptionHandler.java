package com.apps.restspringboot;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apps.restspringboot.Post.PostNotFoundException;
import com.apps.restspringboot.User.UserNotFoundException;

@ControllerAdvice
@RestController
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exr = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(exr, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ UserNotFoundException.class, PostNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exr = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(exr, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub

		ExceptionResponse resp = new ExceptionResponse(new Date(), "Validation failed",
				ex.getBindingResult().getAllErrors().stream().map(objErr ->{
					
					return objErr.getDefaultMessage();
				}).collect(Collectors.toList()).toString());

		return new ResponseEntity<Object>(resp, HttpStatus.BAD_REQUEST);

	}

}
