package com.pod8.portal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.model.PropertyModel;

@Service
public interface PortalPropertyService {
	
	public ModelAndView getUpdateBusinessProperty(String bid,String pid,HttpServletRequest request);
	
	public ModelAndView getCreateBusinessProperty(String bId,HttpServletRequest request);
	
	public ModelAndView postCreateProperty(PropertyModel propertyModel,HttpServletRequest request);
	
	public ModelAndView postUpdateProperty(PropertyModel propertyModel,HttpServletRequest request);
	
	public ModelAndView getShowPropertyList(String bId,HttpServletRequest request);
	
	

}
