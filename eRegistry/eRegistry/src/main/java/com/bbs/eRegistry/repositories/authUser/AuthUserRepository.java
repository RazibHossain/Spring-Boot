package com.bbs.eRegistry.repositories.authUser;


import com.bbs.eRegistry.entities.authUser.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);
    Optional<AuthUser> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}