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
public class PropertyModel {

	@NotBlank(message = "Please enter property id")
	private String pId;
	@Min(value = 1000, message = "Building Area must be greater than 1000 sq feet")
	private long buildingArea;
	@NotBlank(message = "Please enter building type")
	private String buildingType;
	@Min(value = 0, message = "Building Storey cannot be negative")
	private int buildingStorey;
	@Min(value = 0, message = "Building Age cannot be negative")
	private int buildingAge;
	@Min(value = 100000, message = "Cost Of Asset must be greater then 1,00,000")
	private long costOfAsset;
	@Min(value = 20000, message = "Salvage Value must be greater then 20,000")
	private long salvageValue;
	@Min(value = 5, message = "Useful Life must be greater than 5 Years")
	private int usefulLife;
	@NotBlank(message = "Please enter business id")
	private String bId;

}
