package com.nayak.sntask;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@SpringBootApplication
public class SnTaskApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SnTaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

        System.out.println("Hello from the cloud task!!!");

	}
}
