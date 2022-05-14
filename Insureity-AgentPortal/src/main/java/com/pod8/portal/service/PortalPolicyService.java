package com.pod8.portal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.model.ConsumerPolicy;
import com.pod8.portal.model.PolicyMaster;

public interface PortalPolicyService {
	
	public ModelAndView getCreatePolicy(HttpServletRequest request);
	
	public ModelAndView getInsurePolicy(HttpServletRequest request);
	
	public ModelAndView getViewPolicyCidPid(HttpServletRequest request);
	
	public ModelAndView postCreatePolicy(PolicyMaster policyMaster,HttpServletRequest request);
	
	public ModelAndView postIssuePolicy(ConsumerPolicy consumerPolicy,HttpServletRequest request);
	
	public ModelAndView getViewPolicyForCustomer(String cid,String pid ,HttpServletRequest request);
	
	
	
	

}
