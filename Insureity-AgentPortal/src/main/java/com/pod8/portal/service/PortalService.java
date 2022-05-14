package com.pod8.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.model.AgentLoginCredential;

@Service
public interface PortalService {
	
	public int propertyValue(int annualDep);
	
	public ModelAndView getHome(HttpServletRequest request);
	
	public ModelAndView getLogout(HttpSession session);
	
	public ModelAndView postLogin(AgentLoginCredential credential,HttpServletRequest request);
	
	public ModelAndView getShowValue(String bId,String cId,HttpServletRequest request);
	
	public ModelAndView getShowValue( String cId,HttpServletRequest request) ;
	
	public ModelAndView getQuoteValue(int businessValue,String propertyType,int propertyValue,HttpServletRequest request);
	
	public ModelAndView getquote( String bid, String pid,HttpServletRequest request);

}
