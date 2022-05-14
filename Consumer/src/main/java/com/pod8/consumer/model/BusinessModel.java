package com.pod8.consumer.model;

import javax.validation.constraints.Min;
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
public class BusinessModel {

	@NotBlank(message = "Please enter business id")
	private String bId;
	@NotBlank(message = "Please enter business type")
	private String businessType;
	@Min(value = 0, message = "Turn Over cannot be negative")
	private long turnOver;
	@Min(value = 0, message = "Capital Invested cannot be negative")
	private long capitalInvested;
	@Min(value = 0, message = "Number Of Employees cannot be negative")
	private long noOfEmployees;
	@NotBlank(message = "Please enter consumer id")
	private String cId;

}
