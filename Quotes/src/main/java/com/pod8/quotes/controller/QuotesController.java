package com.pod8.quotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pod8.quotes.client.AuthClient;
import com.pod8.quotes.entity.QuotesMaster;
import com.pod8.quotes.model.AuthResponse;
import com.pod8.quotes.services.QuotesService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/quotes")
@RestController
@Slf4j
public class QuotesController {

	@Autowired
	QuotesService quotesService;

	@Autowired
	AuthClient authClient;

	@GetMapping("/getQuotesForPolicy/{businessValue}/{propertyValue}/{propertyType}")
	public ResponseEntity<QuotesMaster> getQuotes(@RequestHeader(name = "Authorization") String token,
			@PathVariable("businessValue") int businessValue, @PathVariable("propertyValue") int propertyValue,
			@PathVariable("propertyType") String propertyType) {
		log.debug("Entering getQuote Controller Method !!!");
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse.isValid()) {
			QuotesMaster quotesForPolicy = quotesService.getQuotesForPolicy(businessValue, propertyValue, propertyType);
			log.info("Quote: {}", quotesForPolicy.toString());
			return new ResponseEntity<>(quotesForPolicy, HttpStatus.OK);
		}
		log.debug("Exiting getQuote Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}

}
