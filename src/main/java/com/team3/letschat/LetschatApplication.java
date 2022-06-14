package com.team3.letschat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class LetschatApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(LetschatApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	//TODO: Fix CORS with work around or Implement CORS filter / Configuration for Graphql, Finish ChatServer and Chatroom DataFetchers
	// Create APP main page & user profile page using Material UI on FrontEnd.
	// Research Utility Classes + add @Secured("RoleType") for user_authorized operations to GraphQL endpoints
}

