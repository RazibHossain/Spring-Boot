package com.razib.apigateway.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "role_service_permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleServicePermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleId;
    private String serviceName;
    private String permissionName;


}
