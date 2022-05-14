package com.pod8.policy.model;

import java.util.Date;

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
public class ConsumerModel {

	private String cId;
	private String name;
	private String businessType;
	private Date dOB;
	private String email;
	private String pan;
	private String agentName;
}
