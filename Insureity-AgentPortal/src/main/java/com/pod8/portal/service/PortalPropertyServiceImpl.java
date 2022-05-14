package com.pod8.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.client.ConsumerClient;
import com.pod8.portal.model.PropertyModel;
import com.pod8.portal.model.ValueModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PortalPropertyServiceImpl implements PortalPropertyService {

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
	public ModelAndView getUpdateBusinessProperty(String bid, String pid, HttpServletRequest request) {
		log.debug("getUpdateBusinessProperty portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				ModelAndView modelandview = new ModelAndView("updatebusinessproperty");
				List<PropertyModel> viewBusinessProperty = consumerClient.viewBusinessProperty(token, bid);
				for (PropertyModel property : viewBusinessProperty) {
					if (property.getPid().equals(pid)) {
						modelandview.addObject("propertyModel", property);
						log.debug("getUpdateBusinessProperty portal service method exited successfully!!!");
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
	public ModelAndView getCreateBusinessProperty(String bId, HttpServletRequest request) {
		log.debug("getCreateBusinessProperty portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			ModelAndView modelAndView = new ModelAndView("createbusinessproperty");
			modelAndView.addObject("bId", bId);
			log.debug("getCreateBusinessProperty portal service method exited successfully!!!");
			return modelAndView;
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView postCreateProperty(PropertyModel propertyModel, HttpServletRequest request) {
		log.debug("postCreateProperty portal service method calledy!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				consumerClient.createBusinessProperty(token, propertyModel);
				ModelAndView modelandview = new ModelAndView("createbusinessproperty");
				modelandview.addObject(sucMessage, "Property Created Seccessfully !!");
				log.debug("postCreateProperty portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				ModelAndView modelandview = new ModelAndView("createbusinessproperty");
				modelandview.addObject(failMessage, "Property Id already Exist");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView postUpdateProperty(PropertyModel propertyModel, HttpServletRequest request) {
		log.debug("postUpdateProperty portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				consumerClient.updateBusinessProperty(token, propertyModel);
				ModelAndView modelandview = new ModelAndView("updatebusinessproperty");
				modelandview.addObject(sucMessage, "Property Updated Seccessfully !!");
				log.debug("postUpdateProperty portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("updatebusinessproperty");
				modelandview.addObject(failMessage, "Property Id already Exist");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getShowPropertyList(String bId, HttpServletRequest request) {
		log.debug("getShowProperty portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				List<PropertyModel> viewBusinessProperty = consumerClient.viewBusinessProperty(token, bId);
				ValueModel value = consumerClient.getBusinessDetails(token, bId);
				ModelAndView modelandview = new ModelAndView("allproperty");
				modelandview.addObject("bval", value.getBusinessValue());
				modelandview.addObject("plist", viewBusinessProperty);
				log.debug("getShowProperty portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("allproperty");
				modelandview.addObject(failMessage, "Unexpected Error Occured");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

}
