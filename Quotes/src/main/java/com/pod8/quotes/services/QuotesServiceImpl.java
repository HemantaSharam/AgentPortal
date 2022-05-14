package com.pod8.quotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod8.quotes.entity.QuotesMaster;
import com.pod8.quotes.exception.QuoteNotFoundException;
import com.pod8.quotes.repository.QuotesRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuotesServiceImpl implements QuotesService {

	@Autowired
	QuotesRepository quotesrepository;

	@Override
	public QuotesMaster getQuotesForPolicy(int businessValue, int propertyValue, String propertyType) {
		log.debug("Entering getQuotesForPolicy Service method !!!");
		log.debug("Exiting getQuotesForPolicy Service method !!!");
		return quotesrepository.getQuotesForPolicy(businessValue, propertyValue, propertyType)
				.orElseThrow(QuoteNotFoundException::new);
	}

}
