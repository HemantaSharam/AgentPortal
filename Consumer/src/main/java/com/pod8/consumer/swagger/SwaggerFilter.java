package com.pod8.consumer.swagger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class SwaggerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Swagger Filter servlet instantiated!!!");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		log.debug("Swagger Filter doFilter method called!!!");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		log.info("Request: {}",servletRequest.toString());
        log.info("Response: {}",servletResponse.toString());
		if (request.getRequestURI().equals("/consumer/swagger")) {
			response.sendRedirect("/swagger-ui.html");
			return;
		}
		if (request.getRequestURI().equals("/consumer/h2")) {
			response.sendRedirect("/h2-console");
			return;
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void destroy() {
	}
}