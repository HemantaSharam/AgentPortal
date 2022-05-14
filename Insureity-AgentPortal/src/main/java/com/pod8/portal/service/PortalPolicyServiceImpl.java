package com.pod8.portal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.client.PolicyClient;
import com.pod8.portal.model.ConsumerPolicy;
import com.pod8.portal.model.PolicyMaster;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PortalPolicyServiceImpl implements PortalPolicyService {

	@Autowired
	PolicyClient policyClient;

	String tokennullinfo = "Session Expired ! Login Again to Continue.";
	String urltoken = "token";
	String error = "error";
	String login = "login";
	String sucMessage = "sucMessage";
	String failMessage = "failMessage";
	String unavailable = "ServiceUnavailable";

	@Override
	public ModelAndView getCreatePolicy(HttpServletRequest request) {
		log.debug("getCreatePolicy portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			log.debug("getCreatePolicy portal service method exited successfully!!!");
			return new ModelAndView("createpolicy");
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getInsurePolicy(HttpServletRequest request) {
		log.debug("getInsurePolicy portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			log.debug("getInsurePolicy portal service method exited successfully!!!");
			return new ModelAndView("insurepolicy");
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getViewPolicyCidPid(HttpServletRequest request) {
		log.debug("getViewPolicy portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			log.debug("getViewPolicy portal service method exited successfully!!!");
			return new ModelAndView("viewpolicycidpid");
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView postCreatePolicy(PolicyMaster policyMaster, HttpServletRequest request) {
		log.debug("postCreatePolicy portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				policyClient.createPolicy(token, policyMaster);
				ModelAndView modelandview = new ModelAndView("createpolicy");
				modelandview.addObject(sucMessage, "Policy Created Seccessfully !!");
				log.debug("postCreatePolicy portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("createpolicy");
				modelandview.addObject(failMessage, "Policy Id already Exist");
				return modelandview;
			}

		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView postIssuePolicy(ConsumerPolicy consumerPolicy, HttpServletRequest request) {
		log.debug("postIssuePolicy portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				policyClient.issuePolicy(token, consumerPolicy);
				ModelAndView modelandview = new ModelAndView("insurepolicy");
				modelandview.addObject(sucMessage, "Policy Created For Consumer !!");
				log.debug("postIssuePolicy portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("insurepolicy");
				modelandview.addObject(failMessage, "Please Check Data and Try Again");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getViewPolicyForCustomer(String cid, String pid, HttpServletRequest request) {
		log.debug("getViewPolicyForCustomer portal service method called!!!");
		log.info("Customer Cid: {}", cid);
		log.info("Customer Pid: {}", pid);
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				ConsumerPolicy consumerPolicy = policyClient.viewPolicy(token, cid, pid);
				ModelAndView modelandview = new ModelAndView("customerpolicy");
				modelandview.addObject("consumerPolicy", consumerPolicy);
				log.debug("getCreatePolicyForCustomer portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("viewpolicycidpid");
				modelandview.addObject(failMessage, "Policy Does Not Exist");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

}
