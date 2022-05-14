package com.pod8.consumer.service;

import java.util.List;

import com.pod8.consumer.model.PropertyModel;

public interface PropertyService {
	public PropertyModel createBusinessProperty(PropertyModel propertyModel);

	public PropertyModel updateBusinessProperty(PropertyModel propertyModel);

	public List<PropertyModel> viewBusinessProperty(String bId);
}
