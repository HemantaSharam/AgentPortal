package com.pod8.portal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod8.portal.model.ConsumerPolicy;
import com.pod8.portal.model.PolicyMaster;
import com.pod8.portal.model.QuotesMaster;

@FeignClient(url = "${policy.url}", name = "Policy")
public interface PolicyClient {

	@PostMapping("/createPolicy")
	public PolicyMaster createPolicy(@RequestHeader(name = "Authorization") String token,
			@RequestBody PolicyMaster policy);

	@PostMapping("/issuePolicy")
	public ConsumerPolicy issuePolicy(@RequestHeader(name = "Authorization") String token,
			@RequestBody ConsumerPolicy policy);

	@GetMapping("/viewPolicy")
	public List<PolicyMaster> allPolicyView();

	@GetMapping("/viewPolicy/{cid}/{pid}")
	public ConsumerPolicy viewPolicy(@RequestHeader(name = "Authorization") String token,
			@PathVariable("cid") String cid, @PathVariable("pid") String pid);

	@GetMapping("/getQuotes/{businessValue}/{propertyValue}/{propertyType}")
	public QuotesMaster getQuotes(@RequestHeader(name = "Authorization") String token,
			@PathVariable("businessValue") int businessValue, @PathVariable("propertyValue") int propertyValue,
			@PathVariable("propertyType") String propertyType);

}
