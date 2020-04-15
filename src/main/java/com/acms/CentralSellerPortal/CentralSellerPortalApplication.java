package com.acms.CentralSellerPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CentralSellerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralSellerPortalApplication.class, args);
	}

}
