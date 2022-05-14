package com.pod8.portal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.model.BusinessModel;

@Service
public interface PortalBusinessService {
	
	public ModelAndView getCreateConsumerBusiness(HttpServletRequest request);
	
	public ModelAndView getViewBusinessId(HttpServletRequest request);
	
	public ModelAndView getUpdateConsumerBusiness(String cId,String bId,HttpServletRequest request);
	
	public ModelAndView postCreateBusiness(BusinessModel businessModel,HttpServletRequest request) ;
	
	public ModelAndView postUpdateBusiness(BusinessModel businessModel,HttpServletRequest request);
	
	public ModelAndView getViewBusiness(String cId,HttpServletRequest request);
	

}
