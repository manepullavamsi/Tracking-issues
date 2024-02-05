package com.spring.Tracking.issues.springplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.Tracking.issues.springplayground.cricularDependency")
public class SpringPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
	}

}
