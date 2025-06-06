package com.ezybytes.webhook_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;


@ConfigurationProperties(prefix = "webhook")
public class WebhookConfigProperties {

    private List<String> refreshUrls;

    public List<String> getRefreshUrls() {
        return refreshUrls;
    }

    public void setRefreshUrls(List<String> refreshUrls) {
        this.refreshUrls = refreshUrls;
    }
}
