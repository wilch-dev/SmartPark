package com.walcfpw.smartpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartparkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartparkApplication.class, args);
	}

}
