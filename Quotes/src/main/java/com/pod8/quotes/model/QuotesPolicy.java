package com.pod8.quotes.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuotesPolicy {

	@Max(value = 10, message = "Business Value Min cannot be greater than 10")
	private int businessValueMin;

	@Max(value = 10, message = "Business Value Max cannot be greater than 10")
	private int businessValueMax;

	@Max(value = 10, message = "Property Value Min cannot be greater than 10")
	private int propertyValueMin;

	@Max(value = 10, message = "Property Value Max cannot be greater than 10")
	private int propertyValueMax;

	@NotBlank(message = " Property Type Field Cannot Be Empty")
	private String propertyType;

}
