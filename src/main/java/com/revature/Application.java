package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	* This method is required for Swagger documentation of this service.
	* 
	*@return A Docket necessary for Swagger documentation
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.revature"))
				.paths(PathSelectors.any()).build();
	}
}
