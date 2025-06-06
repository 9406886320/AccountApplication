package com.ezybytes.webhook_service.controller;

import com.ezybytes.webhook_service.config.WebhookConfigProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/webhook")
public class GitWebhookController {

    private final RestTemplate restTemplate = new RestTemplate();
    // URLs of your running services
    private final WebhookConfigProperties configProperties;

    public GitWebhookController(WebhookConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody JsonNode payload) {
        System.out.println("Received GitHub webhook");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // ✅ Fix: prevent 415 error
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);

        configProperties.getRefreshUrls().forEach(serviceUrl ->{
            try {
                restTemplate.postForEntity(serviceUrl, requestEntity, String.class);  // Sends POST with proper header
                System.out.println("Refreshed: " + serviceUrl);
            } catch (Exception e) {
                System.err.println("Failed to refresh " + serviceUrl + ": " + e.getMessage());
            }
        });
        return ResponseEntity.ok("Webhook processed");
    }
}