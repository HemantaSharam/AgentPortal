package com.pod8.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class InsureityAgentPortalApplication {

	public static void main(String[] args) {
		log.debug("Portal Application main method called!!!");
		SpringApplication.run(InsureityAgentPortalApplication.class, args);
		log.debug("Portal Application main method exited!!!");
	}

}
