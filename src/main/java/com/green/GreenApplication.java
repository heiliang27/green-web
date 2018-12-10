package com.green;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreenApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreenApplication.class, args);
		System.out.println("*****GreenApplication-启动完成****************************************************");
	}
}
