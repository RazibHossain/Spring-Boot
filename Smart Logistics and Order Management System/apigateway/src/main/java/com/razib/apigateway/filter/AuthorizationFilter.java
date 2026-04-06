package com.razib.apigateway.filter;


import com.razib.apigateway.service.RoleApiPermissionService;
import com.razib.apigateway.service.RoleServicePermissionService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.List;

@Component
@ConditionalOnProperty(
        name = "security.authorization.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private RoleApiPermissionService apiService;

    @Autowired
    private RoleServicePermissionService serviceService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {

            String path = request.getRequestURI();
            String method = request.getMethod();

            List<String> userPermissions = auth.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();

            // 🔥 STEP 1: SERVICE ACCESS CHECK
            String serviceName = extractService(path);

            String requiredServicePermission =
                    serviceService.getServicePermission(serviceName);

            if (requiredServicePermission == null) {

                response.sendError(403, "No service access");
                return;
            }

            // 🔥 STEP 2: API ACCESS CHECK
            String requiredApiPermission =
                    apiService.getApiPermission(serviceName, path, method);

            if (requiredApiPermission == null ) {

                response.sendError(403, "No API access");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private String extractService(String path) {
        if (path.startsWith("/orders")) return "ORDER";
        if (path.startsWith("/payments")) return "PAYMENT";
        if (path.startsWith("/products")) return "PRODUCTS";
        return "UNKNOWN";
    }
}
