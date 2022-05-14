package com.pod8.quotes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "quotes_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuotesMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int businessValueMin;
	private int businessValueMax;
	private int propertyValueMin;
	private int propertyValueMax;
	@Column(length = 30)
	private String propertyType;
	private int quotes;
}
