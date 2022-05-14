package com.pod8.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyMaster {

	@Id
	@Column(length = 5)
	@NotBlank(message = "Id can not be null")
	private String id;
	@Column(length = 30)
	@NotBlank(message = "Property Type can not be null")
	private String propertyType;
	@Column(length = 30)
	@NotBlank(message = "Consumer Type can not be null")
	private String consumerType;
	@Min(value = 100000, message = "Minimum assured sum must be 1,00,000")
	private int assuredSum;
	@Min(value = 1, message = "Minimum tenure must be 1 Year")
	private int tenure;
	@Min(value = 0, message = "Business Value cannot be Negative")
	@Max(value = 10, message = "Business Value cannot be more than 10")
	private int businessValue;
	@Min(value = 0, message = "Property Value cannot be Negative")
	@Max(value = 10, message = "Property Value cannot be more than 10")
	private int propertyValue;
	@Column(length = 30)
	@NotBlank(message = "Base Location can not be null")
	private String baseLocation;
	@Column(length = 30)
	@NotBlank(message = "Type can not be null")
	private String type;

}