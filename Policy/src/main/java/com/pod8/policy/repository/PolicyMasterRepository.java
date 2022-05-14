package com.pod8.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pod8.policy.entity.PolicyMaster;

@Repository
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster, String> {

}
