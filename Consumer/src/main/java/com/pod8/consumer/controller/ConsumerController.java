package com.pod8.consumer.controller;

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

import com.pod8.consumer.client.AuthClient;
import com.pod8.consumer.model.AuthResponse;
import com.pod8.consumer.model.BusinessModel;
import com.pod8.consumer.model.ConsumerModel;
import com.pod8.consumer.model.PropertyModel;
import com.pod8.consumer.model.ValueModel;
import com.pod8.consumer.service.BusinessService;
import com.pod8.consumer.service.ConsumerService;
import com.pod8.consumer.service.PropertyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

	@Autowired
	BusinessService businessService;

	@Autowired
	PropertyService propertyService;

	@Autowired
	AuthClient authclient;

	@Autowired
	ConsumerService consumerService;

	@PostMapping(value = "/createConsumerBusiness")
	public ResponseEntity<BusinessModel> createConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody BusinessModel businessModel) {
		log.debug("Entering createConsumerBusiness Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.info("Consumer Business with Business Id: {} is created", businessModel.getBId());
			BusinessModel businessCreated = businessService.createConsumerBusiness(businessModel);
			return new ResponseEntity<>(businessCreated, HttpStatus.OK);
		}
		log.debug("Exiting createConsumerBusiness Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping(value = "/updateConsumerBusiness")
	public ResponseEntity<BusinessModel> updateConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody BusinessModel businessModel) {
		log.debug("Entering updateConsumerBusiness Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.info("Consumer Business with Business Id: {} is updated", businessModel.getBId());
			return new ResponseEntity<>(businessService.updateConsumerBusiness(businessModel), HttpStatus.OK);
		}
		log.debug("Exiting updateConsumerBusiness Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping(value = "/createBusinessProperty")
	public ResponseEntity<PropertyModel> createBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody PropertyModel propertyModel) {
		log.debug("Entering createBusinessProperty Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.info("Consumer Property with Property Id: {} is created", propertyModel.getPId());
			return new ResponseEntity<>(propertyService.createBusinessProperty(propertyModel), HttpStatus.OK);
		}
		log.debug("Exiting createBusinessProperty Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping(value = "/updateBusinessProperty")
	public ResponseEntity<PropertyModel> updateBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody PropertyModel propertyModel) {
		log.debug("Entering updateBusinessProperty Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.info("Consumer Property with Property Id: {} is updated", propertyModel.getPId());
			return new ResponseEntity<>(propertyService.updateBusinessProperty(propertyModel), HttpStatus.OK);
		}
		log.debug("Exiting updateBusinessProperty Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping(value = "/viewConsumerBusiness/{cId}")
	public ResponseEntity<?> viewConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@PathVariable("cId") String cId) {
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.info("All businesses of Consumer: {} is viewed", cId);
			return new ResponseEntity<>(businessService.viewConsumerBusiness(cId), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping(value = "/viewConsumerProperty/{bId}")
	public ResponseEntity<?> viewBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@PathVariable("bId") String bId) {
		log.debug("Entering viewConsumerProperty Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			log.info("All properties of Business: {} is viewed", bId);
			return new ResponseEntity<>(propertyService.viewBusinessProperty(bId), HttpStatus.OK);
		}
		log.debug("Exiting viewConsumerProperty Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/getConsumerDetails/{cId}")
	public ResponseEntity<ConsumerModel> getConsumerDetails(@RequestHeader(name = "Authorization") String token,
			@PathVariable("cId") String cId) {
		log.debug("Entering getConsumerDetails Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(consumerService.findbyId(cId), HttpStatus.OK);
		}
		log.debug("Exiting getConsumerDetails Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/getBusinessDetails/{bId}")
	public ResponseEntity<ValueModel> getBusinessDetails(@RequestHeader(name = "Authorization") String token,
			@PathVariable("bId") String bId) {
		log.debug("Entering getBusinessDetails Controller Method !!!");
		AuthResponse authResponse = authclient.getValidity(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(businessService.findValue(bId), HttpStatus.OK);
		}
		log.debug("Exiting getBusinessDetails Controller Method !!!");
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

}
