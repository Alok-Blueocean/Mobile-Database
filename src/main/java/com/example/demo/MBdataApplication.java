package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.demo,com.example.Entity,com.example.DAO,com.example.Service")
public class MBdataApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext cnfContext = 
				SpringApplication.run(MBdataApplication.class, args);

	}

}
