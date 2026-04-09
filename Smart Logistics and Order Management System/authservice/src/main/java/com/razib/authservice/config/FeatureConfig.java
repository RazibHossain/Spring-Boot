package com.razib.authservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class FeatureConfig {

    @Value("${feature.discount.enabled}")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }
}