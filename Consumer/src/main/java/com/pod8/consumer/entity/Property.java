package com.pod8.consumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

	@Id
	@Column(length = 20)
	private String pId;
	private long buildingArea;
	@Column(length = 30)
	private String buildingType;
	private int buildingStorey;
	private int buildingAge;
	private long costOfAsset;
	private int propertyValue;
	private long salvageValue;
	private int usefulLife;
	@ManyToOne
	@JoinColumn(name = "bId")
	private Business business;

}
