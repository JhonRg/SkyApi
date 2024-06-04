package com.Sky.SkyApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SkyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyApiApplication.class, args);
	}

	@GetMapping("/test")
	public String HelloWorld(){
		return "Hello World";
	}
}
