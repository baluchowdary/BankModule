package com.kollu.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankModuleApplication {

	public static void main(String[] args) {
		System.out.println("i am from bank main module");
		SpringApplication.run(BankModuleApplication.class, args);
	}

}
