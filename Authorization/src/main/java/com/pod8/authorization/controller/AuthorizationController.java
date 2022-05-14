package com.pod8.authorization.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pod8.authorization.model.AgentLoginCredential;
import com.pod8.authorization.model.AgentToken;
import com.pod8.authorization.model.AuthResponse;
import com.pod8.authorization.service.AgentDetailsService;
import com.pod8.authorization.service.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthorizationController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AgentDetailsService agentDetailService;

	@PostMapping(value = "/login")
	public ResponseEntity<AgentToken> login(@Valid @RequestBody AgentLoginCredential agentLoginCredentials) {
		log.debug("Entering login controller method!!!");
		log.info("Agent name: {}", agentLoginCredentials.getAgentId());
		log.info("Agent password: {}", agentLoginCredentials.getPassword());
		final UserDetails userdetails = agentDetailService.loadUserByUsername(agentLoginCredentials.getAgentId(),
				agentLoginCredentials.getPassword());
		log.debug("Exiting login controller method!!!");
		return new ResponseEntity<>(new AgentToken(jwtutil.generateToken(userdetails)), HttpStatus.OK);
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) {
		log.debug("Entering getValidity controller method!!!");
		log.info("Token: {}",token);
		String localToken = token.substring(7);
		AuthResponse response = new AuthResponse();
		if (jwtutil.validateToken(localToken)) {
			response.setValid(true);
		}
		log.info(response.toString());
		log.debug("Exiting getValidity controller method!!!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
