package com.pod8.portal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod8.portal.model.AgentLoginCredential;
import com.pod8.portal.model.AgentToken;
import com.pod8.portal.model.AuthResponse;

@FeignClient(url = "${auth.url}", name = "Auth")
public interface AuthClient {
	@PostMapping(value = "/login")
	public AgentToken login(@RequestBody AgentLoginCredential agentLoginCredentials);
	
	@GetMapping(value="/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
