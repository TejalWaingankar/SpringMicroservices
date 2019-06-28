package com.sync.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringNetflixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNetflixEurekaServerApplication.class, args);
	}

}
