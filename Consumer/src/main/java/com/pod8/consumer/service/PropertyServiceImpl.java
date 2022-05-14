package com.pod8.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod8.consumer.entity.Business;
import com.pod8.consumer.entity.Consumer;
import com.pod8.consumer.entity.Property;
import com.pod8.consumer.exception.BusinessNotFoundException;
import com.pod8.consumer.exception.ConsumerNotFoundException;
import com.pod8.consumer.exception.PropertyAlreadyExistException;
import com.pod8.consumer.exception.PropertyNotFoundException;
import com.pod8.consumer.model.PropertyModel;
import com.pod8.consumer.repository.BusinessRepo;
import com.pod8.consumer.repository.ConsumerRepo;
import com.pod8.consumer.repository.PropertyMasterRepo;
import com.pod8.consumer.repository.PropertyRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyRepo propertyRepo;

	@Autowired
	BusinessRepo businessRepo;

	@Autowired
	ConsumerRepo consumerRepo;

	@Autowired
	PropertyMasterRepo propertyMasterRepo;

	public PropertyModel createBusinessProperty(PropertyModel propertyModel) {
		log.debug("Entering createBusinessProperty Service method");
		log.info("Property Model: {}", propertyModel.toString());
		Property isPropertyPresent = propertyRepo.findById(propertyModel.getPId()).orElse(null);
		if (isPropertyPresent == null) {
			Business business = businessRepo.findById(propertyModel.getBId())
					.orElseThrow(BusinessNotFoundException::new);
			Consumer consumer = consumerRepo.findById(business.getConsumer().getCId())
					.orElseThrow(ConsumerNotFoundException::new);
			log.info("Business Details: {}", business.toString());
			Property property = new Property();
			property.setPId(propertyModel.getPId());
			property.setBuildingAge(propertyModel.getBuildingAge());
			property.setBuildingArea(propertyModel.getBuildingArea());
			property.setBuildingStorey(propertyModel.getBuildingStorey());
			property.setCostOfAsset(propertyModel.getCostOfAsset());
			property.setSalvageValue(propertyModel.getSalvageValue());
			property.setUsefulLife(propertyModel.getUsefulLife());
			long propertyValue = (propertyModel.getCostOfAsset() - propertyModel.getSalvageValue())
					/ propertyModel.getUsefulLife();
			int propertyValueIndex = propertyMasterRepo.getPropertyValue(propertyValue).getPropertyValue();
			if (propertyValueIndex > 10)
				propertyValueIndex = 10;
			property.setPropertyValue(propertyValueIndex);
			property.setBuildingType(propertyModel.getBuildingType());
			property.setBusiness(businessRepo.findById(propertyModel.getBId()).orElse(null));

			List<Property> propertyOverview = business.getProprtiesOverview();
			propertyOverview.add(property);
			business.setProprtiesOverview(propertyOverview);
			consumerRepo.save(consumer);
			log.debug("Exiting createBusinessProperty Service method");
			return propertyModel;
		} else
			throw new PropertyAlreadyExistException();
	}

	public PropertyModel updateBusinessProperty(PropertyModel propertyModel) {
		log.debug("Entering updateBusinessProperty Service method");
		Property returnProperty = propertyRepo.findById(propertyModel.getPId())
				.orElseThrow(PropertyNotFoundException::new);
		if (returnProperty != null) {
			returnProperty.setPId(propertyModel.getPId());
			returnProperty.setBuildingAge(propertyModel.getBuildingAge());
			returnProperty.setBuildingArea(propertyModel.getBuildingArea());
			returnProperty.setBuildingStorey(propertyModel.getBuildingStorey());
			returnProperty.setBuildingType(propertyModel.getBuildingType());
			returnProperty.setCostOfAsset(propertyModel.getCostOfAsset());
			int propertyValue = (int) (propertyModel.getCostOfAsset() - propertyModel.getSalvageValue())
					/ propertyModel.getUsefulLife();
			int propertyValueIndex = propertyMasterRepo.getPropertyValue(propertyValue).getPropertyValue();
			if (propertyValueIndex > 10)
				propertyValueIndex = 10;
			returnProperty.setPropertyValue(propertyValueIndex);
			returnProperty.setSalvageValue(propertyModel.getSalvageValue());
			returnProperty.setUsefulLife(propertyModel.getUsefulLife());
			propertyRepo.save(returnProperty);
		}
		log.info("PropertyModel Details: {}", propertyModel.toString());
		log.debug("Exitng updateBusinessProperty Service method");
		return propertyModel;
	}

	public List<PropertyModel> viewBusinessProperty(String bId) {
		log.debug("Entering viewBusinessProperty Service method");
		List<Property> properties = propertyRepo.findAll();
		List<PropertyModel> propertiesModel = new ArrayList<>();
		for (Property property : properties) {
			if (property.getBusiness().getBId().equals(bId)) {
				PropertyModel model = new PropertyModel();
				model.setPId(property.getPId());
				model.setBuildingAge(property.getBuildingAge());
				model.setBuildingArea(property.getBuildingArea());
				model.setBuildingStorey(property.getBuildingStorey());
				model.setBuildingType(property.getBuildingType());
				model.setCostOfAsset(property.getCostOfAsset());
				model.setSalvageValue(property.getSalvageValue());
				model.setUsefulLife(property.getUsefulLife());
				model.setBId(property.getBusiness().getBId());
				propertiesModel.add(model);
			}
		}
		log.info("PropertyModel Details: {}", propertiesModel.toString());
		log.debug("Exitng viewBusinessProperty Service method");
		return propertiesModel;
	}

}
