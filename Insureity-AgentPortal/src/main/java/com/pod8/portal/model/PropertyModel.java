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
public class PropertyModel {

	private String pid;
	private long buildingArea;
	private String buildingType;
	private int buildingStorey;
	private int buildingAge;
	private long costOfAsset;
	private long salvageValue;
	private int usefulLife;
	private String bid;
	
}
