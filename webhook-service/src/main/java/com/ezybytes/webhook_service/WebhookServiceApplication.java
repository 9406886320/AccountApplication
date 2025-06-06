package com.ezybytes.webhook_service;

import com.ezybytes.webhook_service.config.WebhookConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(WebhookConfigProperties.class)
public class WebhookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebhookServiceApplication.class, args);
	}

}
