package com.pod8.authorization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pod8.authorization.model.Agent;

@Repository
public interface AgentDAO extends JpaRepository<Agent, String> {

}
