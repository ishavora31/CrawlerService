package com.example.web.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlerApplication {
	
	public static int counter = 1;

	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);
	}

}
