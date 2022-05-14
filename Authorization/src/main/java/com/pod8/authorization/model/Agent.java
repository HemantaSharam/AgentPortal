package com.pod8.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agent {

	@Id
	@Column(name = "agentid", length = 20)
	private String agentId;
	@Column(name = "password", length = 20)
	private String password;

}
