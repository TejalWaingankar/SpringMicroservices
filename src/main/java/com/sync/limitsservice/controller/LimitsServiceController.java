package com.sync.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sync.limitsservice.controller.config.AppConfiguration;
import com.sync.limitsservice.controller.model.LimitConfiguration;

@RestController
public class LimitsServiceController {

	@Autowired
	AppConfiguration config;
	
	@GetMapping("/limits")
	public LimitConfiguration getLimitsServiceConfig() {
		return new LimitConfiguration(config.getMinimum(), config.getMaximum());
	}

	/*
	 * Using @Value to read properties file values.
		@Value("${limits.service.minimum}")
		private int mimimum;
		
		@Value("${limits.service.maximum}")
		private int maximum;
		
		@GetMapping("/limits")
		public LimitConfiguration getLimitsServiceConfig() {
			return new LimitConfiguration(mimimum, maximum);
		}
	*/
	
	/*
	 * Using Environment variable to read properties file values.
		@Autowired
		Environment env;
		
		@GetMapping("/limits")
		public LimitConfiguration getLimitsServiceConfig() {
			return new LimitConfiguration(Integer.valueOf(env.getProperty("minimum")), Integer.valueOf(env.getProperty("maximum")));
		}
	*/
}
