package com.shots.ShotsByNakya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages="com.shots")
@SpringBootApplication
public class ShotsByNakyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShotsByNakyaApplication.class, args);
	}

}
