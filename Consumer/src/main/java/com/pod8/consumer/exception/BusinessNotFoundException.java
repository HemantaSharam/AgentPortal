package com.pod8.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Business does not exist")
public class BusinessNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
