package com.team3.letschat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LetschatApplication {

	static final Logger log = LoggerFactory.getLogger(LetschatApplication.class);

	public static void main(String[] args)
	{
		log.info("Starting Letschat application");
		SpringApplication.run(LetschatApplication.class, args);
		log.debug("Finished Letschat application");
		log.info("App starting...");
	}

	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}

