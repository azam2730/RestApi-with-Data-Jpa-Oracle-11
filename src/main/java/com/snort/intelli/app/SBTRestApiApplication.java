package com.snort.intelli.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBTRestApiApplication {

	private static Logger log = LoggerFactory.getLogger(SBTRestApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SBTRestApiApplication.class, args);
		log.info("Rest Api is Running fine");
	}

}
