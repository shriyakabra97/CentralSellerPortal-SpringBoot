package com.acms.CentralSellerPortal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
@EnableJpaRepositories
public class CentralSellerPortalApplication  {


	public static void main(String[] args) throws Exception{
		SpringApplication.run(CentralSellerPortalApplication.class, args);


	}


}
