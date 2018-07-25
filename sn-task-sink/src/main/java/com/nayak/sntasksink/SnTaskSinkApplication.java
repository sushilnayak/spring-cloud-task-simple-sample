package com.nayak.sntasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SnTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnTaskSinkApplication.class, args);
	}
}
