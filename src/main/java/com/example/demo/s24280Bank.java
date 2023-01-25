package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class s24280Bank {

	public static void main(String[] args) {
		SpringApplication.run(s24280Bank.class, args);
	}

	public s24280Bank(BankService bankService) {

		//System.out.println(bankService.registerNewUser(10, 1000));
		//System.out.println(bankService.transferRequest(10, 100));
		//System.out.println(bankService.putMoneyOnAccount(10, 200));
		//System.out.println(bankService.readUserCredentials(10));
	}
}
