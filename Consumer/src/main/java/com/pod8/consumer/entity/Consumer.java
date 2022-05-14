package com.pod8.consumer.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Consumer {
	@Id
	@Column(length = 20)
	private String cId;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String businessType;
	private Date dOB;
	@Column(length = 50)
	private String email;
	@Column(length = 16)
	private String pan;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cId")
	private List<Business> businessOverview = new ArrayList<>();
	@Column(name = "agentname", length = 30)
	private String agentName;
}
