package com.pod8.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod8.consumer.entity.Business;
import com.pod8.consumer.entity.Consumer;
import com.pod8.consumer.entity.Property;
import com.pod8.consumer.exception.BusinessAlreadyExistException;
import com.pod8.consumer.exception.BusinessNotFoundException;
import com.pod8.consumer.exception.ConsumerNotFoundException;
import com.pod8.consumer.model.BusinessModel;
import com.pod8.consumer.model.ValueModel;
import com.pod8.consumer.repository.BusinessRepo;
import com.pod8.consumer.repository.ConsumerRepo;
import com.pod8.consumer.repository.PropertyRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {
	@Autowired
	BusinessRepo businessRepo;

	@Autowired
	ConsumerRepo consumerRepo;

	@Autowired
	PropertyRepo propertyRepo;

	public BusinessModel createConsumerBusiness(BusinessModel businessModel) {
		log.debug("Entering createBusinessModel Service Method !!!");
		Business isBusinessPresent = businessRepo.findById(businessModel.getBId()).orElse(null);
		if (isBusinessPresent == null) {
			log.info("Business Model: {}",businessModel.toString());
			Consumer consumer = consumerRepo.findById(businessModel.getCId())
					.orElseThrow(ConsumerNotFoundException::new);
			log.info("Consumer Details: {}",consumer.toString());
			Business business = new Business();
			business.setBId(businessModel.getBId());
			business.setBusinessType(businessModel.getBusinessType());
			business.setCapitalInvested(businessModel.getCapitalInvested());
			business.setNoOfEmployees(businessModel.getNoOfEmployees());
			business.setTurnOver(businessModel.getTurnOver());
			int businessValue = (int) (businessModel.getTurnOver() / businessModel.getCapitalInvested());
			if (businessValue > 10)
				businessValue = 10;
			business.setBusinessValue(businessValue);
			business.setConsumer(consumerRepo.findById(businessModel.getCId()).orElse(null));
			business.setProprtiesOverview(new ArrayList<>());
			List<Business> businessOverview = consumer.getBusinessOverview();
			businessOverview.add(business);
			consumerRepo.save(consumer);
			log.debug("Exiting createBusinessModel Service Method !!!");
			return businessModel;
		} else
			throw new BusinessAlreadyExistException();
	}

	public BusinessModel updateConsumerBusiness(BusinessModel businessModel) {
		log.debug("Entering updateConsumerBusiness Service Method !!!");
		Business returnBusiness = businessRepo.findById(businessModel.getBId())
				.orElseThrow(BusinessNotFoundException::new);
		if (returnBusiness != null) {
			returnBusiness.setBId(businessModel.getBId());
			returnBusiness.setBusinessType(businessModel.getBusinessType());
			returnBusiness.setCapitalInvested(businessModel.getCapitalInvested());
			returnBusiness.setNoOfEmployees(businessModel.getNoOfEmployees());
			int businessValue = (int) (businessModel.getTurnOver() / businessModel.getCapitalInvested());
			if (businessValue > 10)
				businessValue = 10;
			returnBusiness.setBusinessValue(businessValue);
			returnBusiness.setTurnOver(businessModel.getTurnOver());
			businessRepo.save(returnBusiness);
		}
		log.info("BusinessModel Details: {}",businessModel.toString());
		log.debug("Exiting updateConsumerBusiness Service Method !!!");
		return businessModel;
	}

	public List<BusinessModel> viewConsumerBusiness(String cId) {
		log.debug("Entering viewConsumerBusiness Service Method !!!");
		List<Business> businesses = businessRepo.findAll();
		List<BusinessModel> businessModel = new ArrayList<>();
		for (Business business : businesses) {
			if (business.getConsumer().getCId().equals(cId)) {
				BusinessModel model = new BusinessModel();
				model.setBId(business.getBId());
				model.setBusinessType(business.getBusinessType());
				model.setCapitalInvested(business.getCapitalInvested());
				model.setNoOfEmployees(business.getNoOfEmployees());
				model.setTurnOver(business.getTurnOver());
				model.setCId(business.getConsumer().getCId());
				businessModel.add(model);
			}
		}
		log.info("BusinessModel Details: {}",businessModel.toString());
		log.debug("Exiting viewConsumerBusiness Service Method !!!");
		return businessModel;

	}

	@Override
	public ValueModel findValue(String id) {
		log.debug("Entering findValue Service Method !!!");
		Business business = businessRepo.findById(id).orElseThrow(BusinessNotFoundException::new);
		ValueModel model = new ValueModel();
		model.setBusinessValue(business.getBusinessValue());
		List<Property> propertyList = business.getProprtiesOverview();
		if (propertyList == null || propertyList.isEmpty())
			model.setPropertyValue(0);
		else {
			int sum = 0;
			for (Property p : propertyList) {
				sum += p.getPropertyValue();
			}
			sum = sum / propertyList.size();
			model.setPropertyValue(sum);
		}
		log.info("ValueModel Details: {}",model.toString());
		log.debug("Exiting findValue Service Method !!!");
		return model;
	}

}
