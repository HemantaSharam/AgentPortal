package com.pod8.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.client.ConsumerClient;
import com.pod8.portal.model.BusinessModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PortalBusinessServiceImpl implements PortalBusinessService {

	@Autowired
	ConsumerClient consumerClient;

	String tokennullinfo = "Session Expired ! Login Again to Continue.";
	String urltoken = "token";
	String error = "error";
	String login = "login";
	String sucMessage = "sucMessage";
	String failMessage = "failMessage";
	String unavailable = "ServiceUnavailable";

	@Override
	public ModelAndView getCreateConsumerBusiness(HttpServletRequest request) {
		log.debug("getCreateCustomerBusiness portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			log.debug("getCreateCustomerBusiness portal service method exited successfully!!!");
			return new ModelAndView("createconsumerbusiness");
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;
		}
	}

	@Override
	public ModelAndView getViewBusinessId(HttpServletRequest request) {
		log.debug("getViewBusiness portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			log.debug("getViewBusiness portal service method exited successfully!!!");
			return new ModelAndView("viewbusinessid");
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getUpdateConsumerBusiness(String cId, String bId, HttpServletRequest request) {
		log.debug("getUpdateCustomerBusiness portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				ModelAndView modelandview = new ModelAndView("updateconsumerbusiness");
				List<BusinessModel> viewConsumerBusiness = consumerClient.viewConsumerBusiness(token, cId);
				for (BusinessModel business : viewConsumerBusiness) {
					if (business.getBid().equals(bId)) {
						modelandview.addObject("businessModel", business);
						log.debug("getUpdateCustomerBusiness portal service method exited successfully!!!");
						return modelandview;
					}
				}
				modelandview.addObject(failMessage, "Unexpected Error Occur");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				return new ModelAndView(error);
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView postCreateBusiness(BusinessModel businessModel, HttpServletRequest request) {
		log.debug("postCreateBusiness portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				consumerClient.createConsumerBusiness(token, businessModel);
				ModelAndView modelandview = new ModelAndView("createconsumerbusiness");
				modelandview.addObject(sucMessage, "Business Created Seccessfully !!");
				log.debug("postCreateBusiness portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("createconsumerbusiness");
				modelandview.addObject(failMessage, "Business Id already Exist");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView postUpdateBusiness(BusinessModel businessModel, HttpServletRequest request) {
		log.debug("postUpdateBusiness portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				consumerClient.updateConsumerBusiness(token, businessModel);
				ModelAndView modelandview = new ModelAndView("updateconsumerbusiness");
				modelandview.addObject(sucMessage, "Updated Business Seccessfully !!");
				log.debug("postUpdateBusiness portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("updateconsumerbusiness");
				modelandview.addObject(failMessage, "Business Id already Exist");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getViewBusiness(String cId, HttpServletRequest request) {
		log.debug("getViewBusiness portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				List<BusinessModel> viewConsumerBusiness = consumerClient.viewConsumerBusiness(token, cId);
				ModelAndView modelandview = new ModelAndView("allbusiness");
				modelandview.addObject("blist", viewConsumerBusiness);
				log.debug("getViewBusiness portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("viewbusinessid");
				modelandview.addObject(failMessage, "Consumer ID does not Exist.");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

}
