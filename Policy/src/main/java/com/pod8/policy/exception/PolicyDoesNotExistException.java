package com.pod8.policy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Policy Does Not Exist")
public class PolicyDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
