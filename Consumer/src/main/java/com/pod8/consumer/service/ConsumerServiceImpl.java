package com.pod8.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod8.consumer.entity.Consumer;
import com.pod8.consumer.exception.ConsumerNotFoundException;
import com.pod8.consumer.model.ConsumerModel;
import com.pod8.consumer.repository.ConsumerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	ConsumerRepo consumerRepo;

	@Override
	public ConsumerModel findbyId(String id) {
		log.debug("Entering findbyId Consumer class Service method");
		Consumer consumer = consumerRepo.findById(id).orElseThrow(ConsumerNotFoundException::new);
		ConsumerModel model = new ConsumerModel();
		model.setAgentName(consumer.getAgentName());
		model.setBusinessType(consumer.getBusinessType());
		model.setCId(consumer.getCId());
		model.setDOB(consumer.getDOB());
		model.setEmail(consumer.getEmail());
		model.setName(consumer.getName());
		model.setPan(consumer.getPan());
		log.info("Consumer Details: {}",consumer.toString());
		log.debug("Exiting findbyId Consumer class Service method");
		return model;

	}

}
