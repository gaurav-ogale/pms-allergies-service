package com.citius.allergies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.citius")
@EnableJpaRepositories(basePackages={"com.citius.repository"})
@EntityScan(basePackages = {"com.citius.model"})
public class AllergiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllergiesApplication.class, args);
	}

}
