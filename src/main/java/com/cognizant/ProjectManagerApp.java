package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagerApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProjectManagerApp.class);
        app.run(args);
    }
}
