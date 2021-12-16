package com.bridgelabz.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
        log.info("AddressBook App Started in {} Environment",
                context.getEnvironment().getProperty("environment"));
        log.info("AddressBook App DB User is {}",
                context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
