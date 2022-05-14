package com.pod8.policy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentLoginCredential {
	@NotBlank(message = "ID cannot be null")
	private String agentId;
	@NotBlank(message = "Please enter password")
	@Min(value = 4, message = "Password must contain 4 character")
	private String password;

}
