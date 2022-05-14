package com.pod8.portal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod8.portal.model.ValueModel;
import com.pod8.portal.model.BusinessModel;
import com.pod8.portal.model.PropertyModel;

@FeignClient(url = "${consumer.url}", name = "Consumer")
public interface ConsumerClient {

	@PostMapping(value = "/createConsumerBusiness")
	public BusinessModel createConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@RequestBody BusinessModel businessModel);

	@PostMapping(value = "/updateConsumerBusiness")
	public BusinessModel updateConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@RequestBody BusinessModel businessModel);

	@PostMapping(value = "/createBusinessProperty")
	public PropertyModel createBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@RequestBody PropertyModel propertyModel);

	@PostMapping(value = "/updateBusinessProperty")
	public PropertyModel updateBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@RequestBody PropertyModel propertyModel);

	@GetMapping(value = "/viewConsumerBusiness/{cId}")
	public List<BusinessModel> viewConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@PathVariable("cId") String cId);

	@GetMapping(value = "/viewConsumerProperty/{bId}")
	public List<PropertyModel> viewBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@PathVariable("bId") String bId);
	
	@GetMapping("/getBusinessDetails/{bId}")
	public ValueModel getBusinessDetails(@RequestHeader(name = "Authorization") String token,
			@PathVariable("bId") String bId);

}
