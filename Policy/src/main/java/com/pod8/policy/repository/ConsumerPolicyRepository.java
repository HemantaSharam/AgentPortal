package com.pod8.policy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pod8.policy.entity.ConsumerPolicy;

@Repository
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy, Integer> {

	@Query("SELECT c from CONSUMER_POLICY c where c.consumerId=?1 and  c.policyId=?2")
	public Optional<ConsumerPolicy>  getConsumerPolicyByCidPid(String cid, String pid);

}
