package com.pod8.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPolicy {

	private String businessId;
	private String policyId;
	private String consumerId;
	private String paymentDetails;
	private Boolean acceptanceStatus;

}
