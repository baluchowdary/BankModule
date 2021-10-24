package com.kollu.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class BankModuleApplication {

	private static Logger logger = LoggerFactory.getLogger(BankModuleApplication.class);
	
	public static void main(String[] args) {
		System.out.println("Console:: i am from Bank module");
		logger.info("i am from Bank module");
		SpringApplication.run(BankModuleApplication.class, args);
	}
	
	/*Swagger-api configuration*/
	@Bean
	   public Docket productApi() {
		System.out.println("Console:: BankModuleApplication - Swagger - productApi method");
		logger.info("BankModuleApplication - Swagger - productApi method");
	      return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
	         .apis(RequestHandlerSelectors.basePackage("com.kollu.bank")).build();
	   }
	
	private ApiInfo apiInfo() {
		System.out.println("Console:: BankModuleApplication - Swagger - apiInfo method");
		logger.info("BankModuleApplication - Swagger - apiInfo method");
		return new ApiInfoBuilder().title("Welcome! Bank Micro Service")
				.description("Bank Micro Service Swagger Document")
				.build();
	}
	
	/*Distributed Tracing/Zipkin*/
	
	/*@Bean
	public Sampler defaultSampler() {
		System.out.println("Console:: BankModuleApplication - defaultSampler method");
		logger.info("BankModuleApplication - defaultSampler method");
	    return Sampler.ALWAYS_SAMPLE;
	}*/
	
	
}