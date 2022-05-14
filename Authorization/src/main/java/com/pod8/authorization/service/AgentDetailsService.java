package com.pod8.authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pod8.authorization.dao.AgentDAO;
import com.pod8.authorization.model.Agent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AgentDetailsService implements UserDetailsService {

	@Autowired
	private AgentDAO agentdao;

	@Override
	public UserDetails loadUserByUsername(String uid) {
		log.debug("Entering loadUserByUserName service method!!!");
		Agent agent = agentdao.findById(uid)
				.orElseThrow(() -> new UsernameNotFoundException("User does not exist for the username:"));
		log.info("Agent : {}",agent.toString());
		log.debug("Exiting loadUserByUserName service method!!!");
		return new User(agent.getAgentId(), agent.getPassword(), new ArrayList<>());

	}

	public UserDetails loadUserByUsername(String uid, String password) {
		log.debug("Entering loadUserByUserName service method!!!");
		Agent agent = agentdao.findById(uid)
				.orElseThrow(() -> new UsernameNotFoundException("User does not exist for the username:"));
		log.info("Agent : {}",agent.toString());
		if (agent.getPassword().equals(password)) {
			log.debug("Exiting loadUserByUserName service method!!!");
			return new User(agent.getAgentId(), agent.getPassword(), new ArrayList<>());
		} else
			throw new UsernameNotFoundException("Invalid Password");

	}

}
