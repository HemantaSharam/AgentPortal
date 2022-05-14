package com.pod8.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Consumer does not exist")
public class ConsumerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
