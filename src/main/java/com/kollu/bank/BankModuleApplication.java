package com.kollu.bank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.kollu.bank.security.entity.User;
import com.kollu.bank.security.repository.UserRepository;

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
	
	/*JWT Security*/
	@Autowired
    private UserRepository repository;
	
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
	
/*JWT Security*/
	
	@PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "kollu", "pass"),
                new User(102, "user1", "pwd1"),
                new User(103, "user2", "pwd2"),
                new User(104, "user3", "pwd3")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
	
	/*@PreDestroy
	public void destory() {
		repository.deleteAll();
	}*/
	
}