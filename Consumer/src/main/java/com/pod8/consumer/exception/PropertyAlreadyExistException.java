package com.pod8.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Property with same ID already Exist")
public class PropertyAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
