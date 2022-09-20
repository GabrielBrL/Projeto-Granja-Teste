package com.api.granjacontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GranjaControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GranjaControlApplication.class, args);
	}
}
