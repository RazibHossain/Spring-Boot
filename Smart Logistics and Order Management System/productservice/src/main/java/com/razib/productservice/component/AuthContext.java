package com.razib.productservice.component;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope  // ✅ new instance per request
public class AuthContext {

    private final HttpServletRequest request;

    public AuthContext(HttpServletRequest request) {
        this.request = request;
    }

    public String getUsername() {
        return request.getHeader("X-Auth-User");
    }

    public String getRoles() {
        return request.getHeader("X-Auth-Roles");
    }

    public String getUserId() {
        return request.getHeader("X-Auth-UserId");
    }
}
