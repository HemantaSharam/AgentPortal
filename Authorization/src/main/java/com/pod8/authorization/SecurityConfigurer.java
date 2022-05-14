package com.pod8.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pod8.authorization.service.AgentDetailsService;
import com.pod8.authorization.service.JwtRequestFilter;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Slf4j
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	AgentDetailsService agentDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.debug("Entering AuthenticationManagerBuider configure method!!!");
		super.configure(auth);
		auth.userDetailsService(agentDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		log.debug("Exiting AuthenticationManagerBuider configure method!!!");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.debug("Entering HttpSecurity configure method!!!");
		http.csrf().disable().authorizeRequests().antMatchers("/auth/login").permitAll().anyRequest().authenticated()
				.and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		log.debug("Exiting HttpSecurity configure method!!!");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		log.debug("Creation of Authentication Manager Bean successful!!!");
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		log.debug("Entering WebSecurity configure method!!!");
		web.ignoring().antMatchers("/auth/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui","/auth/h2","/h2-console",
				"/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/auth/swagger");
		log.debug("Exiting WebSecurity configure method!!!");
	}

}
