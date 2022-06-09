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


	//ToDO: Create CommandLine Run to run Chat Server Dao save operation for new Chat server to debug Server
	// or debug the Graphql API I guess.
}
