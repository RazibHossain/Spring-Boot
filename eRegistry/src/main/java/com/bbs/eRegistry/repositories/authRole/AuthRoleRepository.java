package com.bbs.eRegistry.repositories.authRole;

import com.bbs.eRegistry.entities.authRole.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
    Optional<AuthRole> findByName(String name);
    Boolean existsByName(String name);
}