package com.pod8.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Business with same ID already Exist")
public class BusinessAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
