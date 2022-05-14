package com.pod8.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyMaster {

	private String id;
	private String propertyType;
	private String consumerType;
	private int assuredSum;
	private int tenure;
	private int businessValue;
	private int propertyValue;
	private String baseLocation;
	private String type;

}