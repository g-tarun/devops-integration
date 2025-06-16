package com.example.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.learning.*"})
public class WorkspaceApplication {

	public static void main(String[] args) {
		System.out.println("sppliaciur");
		SpringApplication.run(WorkspaceApplication.class, args);
	}

}
