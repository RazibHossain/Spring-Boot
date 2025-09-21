package com.bbs.eRegistry.entities.authUser;

import com.bbs.eRegistry.entities.authRole.AuthRole;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "AUTH_USER")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private Long id;

    @NotEmpty(message = "Username is required")
    @Column(name="USERNAME", nullable=false, length=255)
    private String username;

    @NotEmpty(message = "Password is required")
    @Column(name="PASSWORD", nullable=false, length=255)
    private String password;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name="EMAIL", nullable=false, length=255)
    private String email;

    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "auth_user_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_role_id")
    )
    private Set<AuthRole> roles;

    // Constructors, getters, and setters
    public AuthUser() {}

    public AuthUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public Set<AuthRole> getRoles() { return roles; }
    public void setRoles(Set<AuthRole> roles) { this.roles = roles; }
}