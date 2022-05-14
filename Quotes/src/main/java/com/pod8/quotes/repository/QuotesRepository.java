package com.pod8.quotes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pod8.quotes.entity.QuotesMaster;

@Repository
public interface QuotesRepository extends JpaRepository<QuotesMaster, Integer> {

	@Query(value = "select q from quotes_master q where ?1 BETWEEN q.businessValueMin AND q.businessValueMax and "
			+ "?2 BETWEEN q.propertyValueMin AND q.propertyValueMax and q.propertyType = ?3")
	public Optional<QuotesMaster> getQuotesForPolicy(int businessValue, int propertyValue, String propertyType);

}
