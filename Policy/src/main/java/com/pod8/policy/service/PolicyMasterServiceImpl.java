package com.pod8.policy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod8.policy.entity.PolicyMaster;
import com.pod8.policy.exception.PolicyAlreadyExistException;
import com.pod8.policy.repository.PolicyMasterRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyMasterServiceImpl implements PolicyMasterService {
	@Autowired
	PolicyMasterRepository policymasterrepository;

	@Override
	public PolicyMaster savePolicy(PolicyMaster policy) {
		log.debug("savePolicy service Method called!!!");
		PolicyMaster policyDetails = policymasterrepository.findById(policy.getId()).orElse(null);
		if (policyDetails == null) {
			log.info("Policy Details: {}",policy.toString());
			log.debug("issuePolicy service Method exited!!!");
			return policymasterrepository.save(policy);
		}
		else
			throw new PolicyAlreadyExistException();

	}

	@Override
	public List<PolicyMaster> viewAllPolicy() {
		log.debug("viewAllPolicy service Method called!!!");
		return policymasterrepository.findAll();
	}

}
