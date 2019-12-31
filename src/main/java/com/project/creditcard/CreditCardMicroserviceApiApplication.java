package com.project.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CreditCardMicroserviceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardMicroserviceApiApplication.class, args);
	}

}
