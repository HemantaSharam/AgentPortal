package com.pod8.policy.model;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuotesPolicy {

	@Max(value = 10, message = "Value cannot be greater than 10")
	private int businessValueMin;

	@Max(value = 10, message = "Value cannot be greater than 10")
	private int businessValueMax;

	@Max(value = 10, message = "Value cannot be greater than 10")
	private int propertyValueMin;

	@Max(value = 10, message = "Value cannot be greater than 10")
	private int propertyValueMax;

	private String propertyType;

}
