package com.pod8.quotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.pod8.quotes.swagger.SwaggerFilter;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class QuotesApplication {

	public static void main(String[] args) {
		log.debug("Quotes Application main method called!!!");
		SpringApplication.run(QuotesApplication.class, args);
		log.debug("Quotes Application main method exited!!!");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		log.debug("Entering filterRegisterationBean Method !!!");
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		SwaggerFilter myFilter = new SwaggerFilter();
		filterRegistrationBean.setFilter(myFilter);
		log.debug("Exiting filterRegisterationBean Method !!!");
		return filterRegistrationBean;
	}

}
