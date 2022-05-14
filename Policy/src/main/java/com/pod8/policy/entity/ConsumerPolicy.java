package com.pod8.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CONSUMER_POLICY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 5)
	@NotBlank(message = "Business Id can not be Empty")
	private String businessId;
	@Column(length = 5)
	@NotBlank(message = "Policy Id can not be Empty")
	private String policyId;
	@Column(length = 5)
	@NotBlank(message = "Consumer Id can not be Empty")
	private String consumerId;
	@Column(length = 20)
	@NotBlank(message = "Payment Detail can not be Empty")
	private String paymentDetails;
	private Boolean acceptanceStatus;

}
