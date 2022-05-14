package com.pod8.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.client.AuthClient;
import com.pod8.portal.client.ConsumerClient;
import com.pod8.portal.client.PolicyClient;
import com.pod8.portal.model.AgentLoginCredential;
import com.pod8.portal.model.AgentToken;
import com.pod8.portal.model.BusinessModel;
import com.pod8.portal.model.PolicyMaster;
import com.pod8.portal.model.PropertyModel;
import com.pod8.portal.model.QuotesMaster;
import com.pod8.portal.model.ValueModel;
import com.pod8.portal.repository.MasterRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PortalServiceImpl implements PortalService {

	@Autowired
	MasterRepo masterRepo;

	@Autowired
	AuthClient authClient;

	@Autowired
	ConsumerClient consumerClient;

	@Autowired
	PortalService portalService;

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
	public int propertyValue(int annualDep) {
		log.debug("propertyValue portal service method called!!!");
		return masterRepo.getPropertyValue(annualDep).getPropertyValue();
	}

	@Override
	public ModelAndView getHome(HttpServletRequest request) {
		log.debug("getHome portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				List<PolicyMaster> policyList = policyClient.allPolicyView();
				ModelAndView modelandview = new ModelAndView("portal");
				modelandview.addObject("plist", policyList);
				log.debug("getHome portal service method exited!!!");
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
			log.debug("getHome portal service method exited with null token error!!!");
			return modelandview;
		}
	}

	@Override
	public ModelAndView getLogout(HttpSession session) {
		log.debug("getLogout portal service method called!!!");
		session.setAttribute(urltoken, null);
		session.setAttribute("name", null);
		session.invalidate();
		log.debug("getLogout portal service method exited!!!");
		return new ModelAndView(login);
	}

	@Override
	public ModelAndView postLogin(AgentLoginCredential credential, HttpServletRequest request) {
		log.debug("postLogin portal service method called!!!");
		AgentToken res = null;
		try {
			res = authClient.login(credential);
		} catch (Exception e) {
			log.error(e.getMessage());
			String refused = e.getMessage().substring(0, 18);
			if (refused.equals("Connection refused"))
				return new ModelAndView(unavailable);
			ModelAndView modelandview = new ModelAndView(login);
			String loginfailinfo = "Please Check Your AgentId and Password !!! ";
			modelandview.addObject(error, loginfailinfo);
			return modelandview;
		}
		request.getSession().setAttribute(urltoken, "Bearer " + res.getAuthToken());
		request.getSession().setAttribute("name", credential.getAgentId());
		log.debug("getLogout portal service method exited successfully!!!");
		return getHome(request);
	}

	@Override
	public ModelAndView getShowValue(String bId, String cId, HttpServletRequest request) {
		log.debug("getShowValue portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				ValueModel value = consumerClient.getBusinessDetails(token, bId);
				List<BusinessModel> viewConsumerBusiness = consumerClient.viewConsumerBusiness(token, cId);
				ModelAndView modelandview = new ModelAndView("allbusiness");
				modelandview.addObject("bval", value.getBusinessValue());
				modelandview.addObject("pval", value.getPropertyValue());
				modelandview.addObject("blist", viewConsumerBusiness);
				log.debug("getShowValue portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("allbusiness");
				modelandview.addObject(failMessage, "Unexpected Error Occured");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}

	}

	@Override
	public ModelAndView getShowValue(String cId, HttpServletRequest request) {
		log.debug("getShowValue portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {

				List<BusinessModel> viewConsumerBusiness = consumerClient.viewConsumerBusiness(token, cId);
				ModelAndView modelandview = new ModelAndView("allbusiness");
				modelandview.addObject("bval", null);
				modelandview.addObject("pval", null);
				modelandview.addObject("blist", viewConsumerBusiness);
				log.debug("getShowValue portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("allbusiness");
				modelandview.addObject(failMessage, "Unexpected Error Occured");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}

	}

	@Override
	public ModelAndView getQuoteValue(int businessValue, String propertyType, int propertyValue,
			HttpServletRequest request) {
		log.debug("getQuoteValue portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				QuotesMaster quoteMaster = policyClient.getQuotes(token, businessValue, propertyValue, propertyType);
				ModelAndView modelandview = new ModelAndView("quote");
				modelandview.addObject(sucMessage, "Quote Amount is " + quoteMaster.getQuotes());
				log.debug("getQuoteValue portal service method exited successfully!!!");
				return modelandview;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelandview = new ModelAndView("quote");
				modelandview.addObject(failMessage, "Quote Not Found For the given Data.");
				return modelandview;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}
	}

	@Override
	public ModelAndView getquote(String bid, String pid, HttpServletRequest request) {
		log.debug("getQuote portal service method called!!!");
		String token = (String) request.getSession().getAttribute(urltoken);
		if (token != null) {
			try {
				int businessValue = consumerClient.getBusinessDetails(token, bid).getBusinessValue();
				int propertyValue = 0;
				List<PropertyModel> viewBusinessProperty = consumerClient.viewBusinessProperty(token, bid);
				for (PropertyModel property : viewBusinessProperty) {
					if (property.getPid().equals(pid)) {
						int annualDep = (int) ((property.getCostOfAsset() - property.getSalvageValue())
								/ property.getUsefulLife());
						propertyValue = portalService.propertyValue(annualDep);
						if (propertyValue > 10)
							propertyValue = 10;
					}
				}
				ModelAndView modelAndView = new ModelAndView("quote");
				modelAndView.addObject("bval", businessValue);
				modelAndView.addObject("pval", propertyValue);
				log.debug("getQuote portal service method exited successfully!!!");
				return modelAndView;
			} catch (Exception e) {
				log.error(e.getMessage());
				String refused = e.getMessage().substring(0, 18);
				if (refused.equals("Connection refused"))
					return new ModelAndView(unavailable);
				ModelAndView modelAndView = new ModelAndView("quote");
				modelAndView.addObject(failMessage, "Unexpected Error occured");
				return modelAndView;
			}
		} else {
			ModelAndView modelandview = new ModelAndView(login);
			modelandview.addObject(error, tokennullinfo);
			return modelandview;

		}

	}

}
