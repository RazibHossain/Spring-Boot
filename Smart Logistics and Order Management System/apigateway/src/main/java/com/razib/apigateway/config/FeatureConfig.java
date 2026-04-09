package com.razib.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class FeatureConfig {

    @Value("${security.authorization.enabled}")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }
}