package com.bbs.eRegistry.services.authRole;


import com.bbs.eRegistry.entities.authRole.AuthRole;
import com.bbs.eRegistry.repositories.authRole.AuthRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthRoleService {
    @Autowired
    private AuthRoleRepository roleRepository;

    public List<AuthRole> findAll() {
        return roleRepository.findAll();
    }

    public Optional<AuthRole> findById(Long id) {
        return roleRepository.findById(id);
    }

    public AuthRole save(AuthRole role) {
        return roleRepository.save(role);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public boolean roleExists(String name) {
        return roleRepository.existsByName(name);
    }
}