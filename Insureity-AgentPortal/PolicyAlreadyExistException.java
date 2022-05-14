package com.pod8.policy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Policy Already Exist")
public class PolicyAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
