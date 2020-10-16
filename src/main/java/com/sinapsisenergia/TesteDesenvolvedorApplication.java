package com.sinapsisenergia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = "com.sinapisienergia.entity")

public class TesteDesenvolvedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteDesenvolvedorApplication.class, args);
	}

}
