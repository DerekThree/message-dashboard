package com.itemApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ItemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemApiApplication.class, args);
	}

}
