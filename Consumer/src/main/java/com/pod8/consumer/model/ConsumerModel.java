package com.pod8.consumer.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerModel {

	@NotBlank(message = "Please enter consumer id")
	private String cId;
	@NotBlank(message = "Please enter name")
	private String name;
	@NotBlank(message = "Please enter business type")
	private String businessType;
	private Date dOB;
	@NotBlank(message = "Please enter email")
	private String email;
	@NotBlank(message = "Please enter pan card no.")
	private String pan;
	@NotBlank(message = "Please enter agent name")
	private String agentName;
}
