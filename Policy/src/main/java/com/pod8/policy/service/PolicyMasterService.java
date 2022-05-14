package com.pod8.policy.service;

import java.util.List;

import com.pod8.policy.entity.PolicyMaster;

public interface PolicyMasterService {

	public PolicyMaster savePolicy(PolicyMaster policy);

	public List<PolicyMaster> viewAllPolicy();

}
