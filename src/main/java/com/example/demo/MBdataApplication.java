package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.demo,com.example.Entity,com.example.DAO")
public class MBdataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cnfContext = 
				SpringApplication.run(MBdataApplication.class, args);
//		
//		CustomerDAO customerDAO = new CustomerDAOImpl();
//		customerDAO.getCustomerbyPhone(1);
//		System.out.println("after application");
//		System.out.println(cnfContext.getBean("customer"));
//		String[] customerDAO =  cnfContext.getBeanDefinitionNames();
//		Arrays.stream(customerDAO).forEach(System.out::println);
	
//		Arrays.stream(cnfContext).forEach(System.out::println);;
//		System.out.println(cnfContext.getBean("product"));
	}

}
