package com.bbs.eRegistry.entities.authRole;

import com.bbs.eRegistry.entities.authUser.AuthUser;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "AUTH_ROLE")
public class AuthRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private Long id;

    @NotEmpty(message = "Role name is required")
    @Column(name="NAME", nullable=false, length=255)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<AuthUser> users;

    // Constructors, getters, and setters
    public AuthRole() {}

    public AuthRole(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<AuthUser> getUsers() { return users; }
    public void setUsers(Set<AuthUser> users) { this.users = users; }
}