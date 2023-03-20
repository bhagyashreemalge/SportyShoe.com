package com.simplilearn.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@ComponentScan(basePackages = {"com.simplilearn"})
public class SportyShoesPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesPrototypeApplication.class, args);
	}

}
