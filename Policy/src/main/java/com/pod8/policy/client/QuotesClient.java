package com.pod8.policy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod8.policy.model.QuotesMaster;

@FeignClient(url = "${quotes.url}", name = "quotes")
public interface QuotesClient {

	@GetMapping("/getQuotesForPolicy/{businessValue}/{propertyValue}/{propertyType}")
	public QuotesMaster getQuotes(@RequestHeader(name = "Authorization") String token,
			@PathVariable("businessValue") int businessValue, @PathVariable("propertyValue") int propertyValue,
			@PathVariable("propertyType") String propertyType);
}
