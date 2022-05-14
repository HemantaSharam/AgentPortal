package com.pod8.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PROPERTY_MASTER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long minval;
	private long maxval;
	private int propertyValue;

}
