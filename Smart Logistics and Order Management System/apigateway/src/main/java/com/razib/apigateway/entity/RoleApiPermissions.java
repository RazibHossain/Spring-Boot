package com.razib.apigateway.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role_api_permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleApiPermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleId;
    private String serviceName;
    private String path;
    private String permissionName;
    private String method;

}