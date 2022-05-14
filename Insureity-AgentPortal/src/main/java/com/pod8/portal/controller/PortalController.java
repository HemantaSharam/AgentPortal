package com.pod8.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pod8.portal.model.AgentLoginCredential;
import com.pod8.portal.model.BusinessModel;
import com.pod8.portal.model.ConsumerPolicy;
import com.pod8.portal.model.PolicyMaster;
import com.pod8.portal.model.PropertyModel;
import com.pod8.portal.service.PortalBusinessService;
import com.pod8.portal.service.PortalPolicyService;
import com.pod8.portal.service.PortalPropertyService;
import com.pod8.portal.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PortalController {

	@Autowired
	PortalBusinessService portalBusinessService;

	@Autowired
	PortalPolicyService portalPolicyService;

	@Autowired
	PortalPropertyService portalPropertyService;

	@Autowired
	PortalService portalService;

	@GetMapping(path = "/login")
	public ModelAndView getLogin() {
		log.debug("getLogin Portal Controller Method called!!");
		return new ModelAndView("login");
	}

	@GetMapping(path = "/home")
	public ModelAndView getHome(HttpServletRequest request) {
		log.debug("getHome Portal Controller Method called!!");
		return portalService.getHome(request);
	}
	
	@GetMapping(path="/error")
	public ModelAndView getError() {
		log.debug("getError Portal Controller Method called!!");
		return new ModelAndView("error");
	}

	@GetMapping(path = "/createpolicy")
	public ModelAndView getCreatePolicy(HttpServletRequest request) {
		log.debug("getCreatePolicy Portal Controller Method called!!");
		return portalPolicyService.getCreatePolicy(request);
	}

	@GetMapping(path = "/insurepolicy")
	public ModelAndView getInsurePolicy(HttpServletRequest request) {
		log.debug("getInsurePolicy Portal Controller Method called!!");
		return portalPolicyService.getInsurePolicy(request);
	}

	@GetMapping(path = "/createconsumerbusiness")
	public ModelAndView getCreateConsumerBusiness(HttpServletRequest request) {
		log.debug("getConsumerBusiness Portal Controller Method called!!");
		return portalBusinessService.getCreateConsumerBusiness(request);
	}

	@GetMapping(path = "/viewconsumerbusinessid")
	public ModelAndView getViewBusinessId(HttpServletRequest request) {
		log.debug("getViewBusinessId Portal Controller Method called!!");
		return portalBusinessService.getViewBusinessId(request);
	}

	@GetMapping(path = "/viewpolicycidpid")
	public ModelAndView getViewPolicyCidPid(HttpServletRequest request) {
		log.debug("getViewPolicyCidPid Portal Controller Method called!!");
		return portalPolicyService.getViewPolicyCidPid(request);
	}

	@GetMapping(path = "/updateconsumerbusiness")
	public ModelAndView getUpdateConsumerBusiness(@RequestParam("cId") String cId, @RequestParam("bId") String bId,
			HttpServletRequest request) {
		log.debug("getUpdateConsumerBusiness Portal Controller Method called!!");
		return portalBusinessService.getUpdateConsumerBusiness(cId, bId, request);
	}

	@GetMapping(path = "/updatebusinessproperty")
	public ModelAndView getUpdateBusinessProperty(@RequestParam("bid") String bid, @RequestParam("pid") String pid,
			HttpServletRequest request) {
		log.debug("getUpdateBusinessProperty Portal Controller Method called!!");
		return portalPropertyService.getUpdateBusinessProperty(bid, pid, request);

	}

	@GetMapping(path = "/createbusinessproperty")
	public ModelAndView getCreateBusinessProperty(@RequestParam("bId") String bId, HttpServletRequest request) {
		log.debug("getCreateBusinessProperty Portal Controller Method called!!");
		return portalPropertyService.getCreateBusinessProperty(bId, request);
	}

	@GetMapping(path = "/logout")
	public ModelAndView getLogout(HttpSession session) {
		log.debug("getLogout Portal Controller Method called!!");
		return portalService.getLogout(session);
	}
	
	@GetMapping(path = "/viewpolicy")
	public ModelAndView getViewPolicyForCustomer(@RequestParam("cid") String cid, @RequestParam("pid") String pid,
			HttpServletRequest request) {
		log.debug("getViewPolicyForCustomer Portal Controller Method called!!");
		return portalPolicyService.getViewPolicyForCustomer(cid, pid, request);

	}

	@GetMapping(path = "/showvalue")
	public ModelAndView getShowValue(@RequestParam("bId") String bId, @RequestParam("cId") String cId,
			HttpServletRequest request) {
		log.debug("getShowValue Portal Controller Method called!!");
		return portalService.getShowValue(bId, cId, request);
	}

	@GetMapping(path = "/hidevalue")
	public ModelAndView getShowValue(@RequestParam("cId") String cId, HttpServletRequest request) {
		log.debug("getShowValue Portal Controller Method called!!");
		return portalService.getShowValue(cId, request);
	}

	@GetMapping(path = "/viewbusiness")
	public ModelAndView getViewBusiness(@RequestParam("cId") String cId, HttpServletRequest request) {
		log.debug("getViewBusiness Portal Controller Method called!!");
		return portalBusinessService.getViewBusiness(cId, request);
	}

	@GetMapping(path = "/propertylist")
	public ModelAndView getShowPropertyList(@RequestParam("bId") String bId, HttpServletRequest request) {
		log.debug("getShowPropertyList Portal Controller Method called!!");
		return portalPropertyService.getShowPropertyList(bId, request);
	}

	@GetMapping(path = "/quotevalue")
	public ModelAndView getQuoteValue(@RequestParam("businessValue") int businessValue,
			@RequestParam("propertyType") String propertyType, @RequestParam("propertyValue") int propertyValue,
			HttpServletRequest request) {
		log.debug("getQuoteValue Portal Controller Method called!!");
		return portalService.getQuoteValue(businessValue, propertyType, propertyValue, request);
	}

	@GetMapping(path = "/getquote")
	public ModelAndView getquote(@RequestParam("bid") String bid, @RequestParam("pid") String pid,
			HttpServletRequest request) {
		log.debug("getQuote Portal Controller Method called!!");
		return portalService.getquote(bid, pid, request);

	}


	@PostMapping(path = "/login")
	public ModelAndView postLogin(@ModelAttribute("credential") AgentLoginCredential credential,
			HttpServletRequest request) {
		log.debug("postLogin Portal Controller Method called!!");
		return portalService.postLogin(credential, request);
	}

	@PostMapping(path = "/createproperty")
	public ModelAndView postCreateProperty(@ModelAttribute("propertyModel") PropertyModel propertyModel,
			HttpServletRequest request) {
		log.debug("postCreateProperty Portal Controller Method called!!");
		return portalPropertyService.postCreateProperty(propertyModel, request);
	}

	@PostMapping(path = "/createbusiness")
	public ModelAndView postCreateBusiness(@ModelAttribute("businessModel") BusinessModel businessModel,
			HttpServletRequest request) {
		log.debug("postCreateBusiness Portal Controller Method called!!");
		return portalBusinessService.postCreateBusiness(businessModel, request);
	}

	@PostMapping(path = "/updatebusiness")
	public ModelAndView postUpdateBusiness(@ModelAttribute("businessModel") BusinessModel businessModel,
			HttpServletRequest request) {
		log.debug("postUpdateBusiness Portal Controller Method called!!");
		return portalBusinessService.postUpdateBusiness(businessModel, request);
	}

	@PostMapping(path = "/updateproperty")
	public ModelAndView postUpdateProperty(@ModelAttribute("propertyModel") PropertyModel propertyModel,
			HttpServletRequest request) {
		log.debug("postUpdateProperty Portal Controller Method called!!");
		return portalPropertyService.postUpdateProperty(propertyModel, request);

	}

	@PostMapping(path = "/createpolicy")
	public ModelAndView postCreatePolicy(@ModelAttribute("policyMaster") PolicyMaster policyMaster,
			HttpServletRequest request) {
		log.debug("postCreatePolicy Portal Controller Method called!!");
		return portalPolicyService.postCreatePolicy(policyMaster, request);
	}

	@PostMapping(path = "/issuepolicy")
	public ModelAndView postIssuePolicy(@ModelAttribute("consumerPolicy") ConsumerPolicy consumerPolicy,
			HttpServletRequest request) {
		log.debug("postIssuePolicy Portal Controller Method called!!");
		return portalPolicyService.postIssuePolicy(consumerPolicy, request);
	}

}
