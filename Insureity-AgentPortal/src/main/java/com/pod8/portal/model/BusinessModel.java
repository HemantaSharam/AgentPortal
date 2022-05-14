package com.pod8.portal.model;

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
	
	private String bid;
	private String businessType;
	private long turnOver;
	private long capitalInvested;
	private long noOfEmployees;
	private String cid;
	
}
