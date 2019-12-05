package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.context.properties.ConfigurationPropertiesReportEndpoint.ContextConfigurationProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.demo,com.example.Entity")
public class MBdataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cnfContext = SpringApplication.run(MBdataApplication.class, args);
	
//		Arrays.stream(cnfContext).forEach(System.out::println);;
//		System.out.println(cnfContext.getBean("product"));
	}

}
