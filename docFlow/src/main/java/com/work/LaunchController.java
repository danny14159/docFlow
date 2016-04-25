package com.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class LaunchController extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LaunchController.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LaunchController.class, args);
	}

}
