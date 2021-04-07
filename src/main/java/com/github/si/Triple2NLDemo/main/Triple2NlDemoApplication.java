package com.github.si.Triple2NLDemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.si.Triple2NLDemo.**")
public class Triple2NlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Triple2NlDemoApplication.class, args);
	}

}
