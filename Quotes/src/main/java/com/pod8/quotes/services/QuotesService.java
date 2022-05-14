package com.pod8.quotes.services;

import com.pod8.quotes.entity.QuotesMaster;

public interface QuotesService {

	QuotesMaster getQuotesForPolicy(int businessValue, int propertyValue, String propertyType);
}
