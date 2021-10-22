package com.kollu.bank;

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

	public static void main(String[] args) {
		System.out.println("i am from bank main module");
		SpringApplication.run(BankModuleApplication.class, args);
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
	         .apis(RequestHandlerSelectors.basePackage("com.kollu.bank")).build();
	   }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Welcome! Bank Micro Service")
				.description("Bank Micro Service Swagger Document")
				.build();
	}
}
