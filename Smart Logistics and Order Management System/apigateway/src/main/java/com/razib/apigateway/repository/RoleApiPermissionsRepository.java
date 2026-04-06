package com.razib.apigateway.repository;

import com.razib.apigateway.entity.RoleApiPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleApiPermissionsRepository extends JpaRepository<RoleApiPermissions,Long> {
}
