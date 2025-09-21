package com.bbs.eRegistry.services.authUser;


import com.bbs.eRegistry.entities.authUser.AuthUser;
import com.bbs.eRegistry.repositories.authUser.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthUserService {
    @Autowired
    private AuthUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<AuthUser> findAll() {
        return userRepository.findAll();
    }

    public Optional<AuthUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public AuthUser save(AuthUser user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean resetPassword(Long userId, String newPassword) {
        Optional<AuthUser> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            AuthUser user = userOptional.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}