package com.ezybytes.webhook_service.controller;

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
    private static final String[] SERVICES = {
            "http://localhost:8080/actuator/busrefresh", // accounts
            "http://localhost:8091/actuator/busrefresh", // loans
            "http://localhost:9000/actuator/busrefresh"  // cards
    };
    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody JsonNode payload) {
        System.out.println("Received GitHub webhook");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // ✅ Fix: prevent 415 error
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);

        for (String serviceUrl : SERVICES) {
            try {
                restTemplate.postForEntity(serviceUrl, requestEntity, String.class);  // Sends POST with proper header
                System.out.println("Refreshed: " + serviceUrl);
            } catch (Exception e) {
                System.err.println("Failed to refresh " + serviceUrl + ": " + e.getMessage());
            }
        }
        return ResponseEntity.ok("Webhook processed");
    }
}