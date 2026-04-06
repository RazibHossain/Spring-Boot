package com.razib.apigateway.service;

import com.razib.apigateway.repository.RoleApiPermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleApiPermissionService {

    @Autowired
    private RoleApiPermissionsRepository repo;

    public String getApiPermission(String serviceName, String path, String method) {

        return repo.findAll().stream()
                .filter(p -> p.getServiceName().equals(serviceName))
                .filter(p -> match(p.getPath(), path))
                .filter(p -> p.getMethod().equalsIgnoreCase(method))
                .map(p -> p.getPermissionName())
                .findFirst()
                .orElse(null);
    }

    private boolean match(String pattern, String path) {
        if (pattern.endsWith("*")) {
            return path.startsWith(pattern.replace("*", ""));
        }
        return pattern.equals(path);
    }
}