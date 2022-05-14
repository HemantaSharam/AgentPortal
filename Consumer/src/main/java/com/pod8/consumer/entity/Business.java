package com.pod8.consumer.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Business {
	@Id
	@Column(length = 20)
	private String bId;
	@Column(length = 30)
	private String businessType;
	private long turnOver;
	private long capitalInvested;
	private long noOfEmployees;
	private int businessValue;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bId")
	private List<Property> proprtiesOverview = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "cId")
	private Consumer consumer;
}
