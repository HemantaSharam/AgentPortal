package com.pod8.policy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod8.policy.client.ConsumerClient;
import com.pod8.policy.entity.ConsumerPolicy;
import com.pod8.policy.entity.PolicyMaster;
import com.pod8.policy.exception.DataNotFoundException;
import com.pod8.policy.exception.PolicyAlreadyExistException;
import com.pod8.policy.exception.PolicyDoesNotExistException;
import com.pod8.policy.model.ValueModel;
import com.pod8.policy.repository.ConsumerPolicyRepository;
import com.pod8.policy.repository.PolicyMasterRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerPolicyServiceImpl implements ConsumerPolicyService {

	@Autowired
	ConsumerPolicyRepository consumerpolicyrepository;

	@Autowired
	ConsumerClient consumerClient;

	@Autowired
	PolicyMasterRepository policyMasterRepository;

	@Override
	public ConsumerPolicy issuePolicy(String token, ConsumerPolicy policy) {
		log.debug("issuePolicy service Method called!!!");
		String consumerId = policy.getConsumerId();
		consumerClient.getConsumerDetails(token, consumerId);
		String businessId = policy.getBusinessId();
		ValueModel valueModel = consumerClient.getBusinessDetails(token, businessId);
		String policyId = policy.getPolicyId();
		PolicyMaster policyDetails = policyMasterRepository.findById(policyId)
				.orElseThrow(PolicyDoesNotExistException::new);
		if (policyDetails.getPropertyValue() == valueModel.getPropertyValue()
				&& policyDetails.getBusinessValue() == valueModel.getBusinessValue()) {
			ConsumerPolicy consumerPolicyByCidPid = consumerpolicyrepository
					.getConsumerPolicyByCidPid(consumerId, policyId).orElse(null);
			if (consumerPolicyByCidPid == null) {
				log.info("Policy Details: {}",policy.toString());
				log.debug("issuePolicy service Method exited!!!");
				return consumerpolicyrepository.save(policy);
			}
			else
				throw new PolicyAlreadyExistException();

		} else
			throw new PolicyDoesNotExistException();
	}

	@Override
	public ConsumerPolicy getConsumerPolicyById(String cid, String pid) {
		log.debug("getConsumerPolicy service Method called!!!");
		return consumerpolicyrepository.getConsumerPolicyByCidPid(cid, pid).orElseThrow(DataNotFoundException::new);
	}
}
