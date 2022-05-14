package com.pod8.quotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Quotes, Contact Insurance Provider")
public class QuoteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
