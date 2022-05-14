package com.pod8.policy.service;

import com.pod8.policy.entity.ConsumerPolicy;

public interface ConsumerPolicyService {

	ConsumerPolicy issuePolicy(String token, ConsumerPolicy policy);

	ConsumerPolicy getConsumerPolicyById(String cid, String pid);

}
