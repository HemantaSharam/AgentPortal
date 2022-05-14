package com.pod8.consumer.service;

import java.util.List;

import com.pod8.consumer.model.BusinessModel;
import com.pod8.consumer.model.ValueModel;

public interface BusinessService {
	public BusinessModel createConsumerBusiness(BusinessModel business);

	public BusinessModel updateConsumerBusiness(BusinessModel businessModel);

	public List<BusinessModel> viewConsumerBusiness(String cId);

	public ValueModel findValue(String id);

}
