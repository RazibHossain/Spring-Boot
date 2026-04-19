package com.razib.apigateway.service;

import com.razib.apigateway.repository.RoleServicePermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServicePermissionService {

    @Autowired
    private RoleServicePermissionsRepository repo;

    public String getServicePermission(String serviceName) {
        System.out.println("heelo");
        return repo.findByServiceName(serviceName)
                .map(r -> r.getPermissionName())
                .orElse(null);
    }
}
