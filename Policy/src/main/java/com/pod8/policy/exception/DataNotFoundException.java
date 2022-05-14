package com.pod8.policy.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data Not Found")
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1558917903293960062L;

}
