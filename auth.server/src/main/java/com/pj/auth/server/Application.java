package com.pj.auth.server;

import com.pj.auth.server.config.DefaultUsersInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner setUp(DefaultUsersInitializer usersInitializer) {
		return args -> {
			usersInitializer.injectAdminUser();
			usersInitializer.injectTestUser();
		};
	}

}
