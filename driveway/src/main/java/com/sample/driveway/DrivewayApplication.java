package com.sample.driveway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sample.driveway")
@EntityScan(basePackages = "com.sample.driveway.model")
@EnableJpaRepositories(basePackages = "com.sample.driveway.repository")
@EnableEurekaClient
public class DrivewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrivewayApplication.class, args);
	}

}
