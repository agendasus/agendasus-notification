package br.com.agendasus.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@EnableEurekaClient
@SpringBootApplication
public class AgendaSUSApp {

	public static String systemVersion;

	public static void main(String[] args) {
		SpringApplication.run(AgendaSUSApp.class, "");
	}

}
