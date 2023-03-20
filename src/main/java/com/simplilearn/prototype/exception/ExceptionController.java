package com.simplilearn.prototype.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value= ProductException.class)
	public ResponseEntity<Object> exception(ProductException exception) {
		return new ResponseEntity<>("Product already exist", HttpStatus.CONFLICT);
	}

}

