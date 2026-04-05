package com.razib.apigateway.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class AuthHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("=== AuthHeaderFilter ===");
        System.out.println("Auth: " + auth);
        System.out.println("Principal: " + (auth != null ? auth.getPrincipal() : "null"));

        if (auth != null && auth.getPrincipal() instanceof Jwt jwt) {
            MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
            mutableRequest.putHeader("X-Auth-User", jwt.getSubject());
            mutableRequest.putHeader("X-Auth-Roles", auth.getAuthorities().toString());
            mutableRequest.putHeader("X-Auth-UserId", jwt.getClaimAsString("sub"));

            System.out.println("X-Auth-User: " + jwt.getSubject());
            filterChain.doFilter(mutableRequest, response);
            return;
        }

        System.out.println("Auth is null or not JWT");
        filterChain.doFilter(request, response);
    }
}