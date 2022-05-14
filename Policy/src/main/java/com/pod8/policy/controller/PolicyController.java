package com.pod8.policy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pod8.policy.client.AuthClient;
import com.pod8.policy.client.QuotesClient;
import com.pod8.policy.entity.ConsumerPolicy;
import com.pod8.policy.entity.PolicyMaster;
import com.pod8.policy.model.AuthResponse;
import com.pod8.policy.model.QuotesMaster;
import com.pod8.policy.service.ConsumerPolicyService;
import com.pod8.policy.service.PolicyMasterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private ConsumerPolicyService consumerpolicyservice;
	@Autowired
	private PolicyMasterService policymasterservice;
	@Autowired
	private QuotesClient quoteclient;
	@Autowired
	private AuthClient authclient;

	@PostMapping("/createPolicy")
	public ResponseEntity<PolicyMaster> createPolicy(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody PolicyMaster policy) {
		log.debug("Entering createPolicy Controller Method !!!");

		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {

			log.debug("Policy Creation !!!! Inside PolicyController");
			PolicyMaster newPolicy = policymasterservice.savePolicy(policy);
			log.info("Policy: {}",newPolicy.toString());
			log.debug("Exiting createPolicy Controller Method !!!");
			return ResponseEntity.ok(newPolicy);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/issuePolicy")
	public ResponseEntity<ConsumerPolicy> issuePolicy(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody ConsumerPolicy policy) {
		log.debug("Entering issuePolicy Controller Method !!!");

		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {

			log.info("Policy issue !!!! Inside PolicyController");
			ConsumerPolicy newPolicy = consumerpolicyservice.issuePolicy(token, policy);
		//	log.info("Policy: {}",newPolicy.toString());
			log.debug("Exiting issuePolicy Controller Method !!!");
			return ResponseEntity.ok(newPolicy);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}

	@GetMapping("/viewPolicy")
	public List<PolicyMaster> allPolicyView() {
		log.debug("viewPolicy Controller Method called!!!");
		return policymasterservice.viewAllPolicy();
	}

	@GetMapping("/viewPolicy/{cid}/{pid}")
	public ConsumerPolicy viewPolicy(@RequestHeader(name = "Authorization") String token,
			@PathVariable("cid") String cid, @PathVariable("pid") String pid) {
		log.debug("viewPolicy by consumer/property Controller Method called!!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.debug("viewPolicy by consumer/property Controller Method exited!!!");
			return consumerpolicyservice.getConsumerPolicyById(cid, pid);
		} else {
			return null;
		}
	}

	@GetMapping("/getQuotes/{businessValue}/{propertyValue}/{propertyType}")
	public QuotesMaster getQuotes(@RequestHeader(name = "Authorization") String token,
			@PathVariable("businessValue") int businessValue, @PathVariable("propertyValue") int propertyValue,
			@PathVariable("propertyType") String propertyType) {
		log.debug("getQuotes Controller Method called!!!");
		return quoteclient.getQuotes(token, businessValue, propertyValue, propertyType);

	}
}
