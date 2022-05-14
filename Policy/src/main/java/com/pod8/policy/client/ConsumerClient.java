package com.pod8.policy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod8.policy.model.ConsumerModel;
import com.pod8.policy.model.ValueModel;

@FeignClient(url = "${consumer.url}", name = "Consumer")
public interface ConsumerClient {

	@GetMapping("/getBusinessDetails/{bId}")
	public ValueModel getBusinessDetails(@RequestHeader(name = "Authorization") String token,
			@PathVariable("bId") String bId);

	@GetMapping("/getConsumerDetails/{cId}")
	public ConsumerModel getConsumerDetails(@RequestHeader(name = "Authorization") String token,
			@PathVariable("cId") String cId);

}
