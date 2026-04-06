package com.razib.apigateway.repository;

import com.razib.apigateway.entity.RoleServicePermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleServicePermissionsRepository extends JpaRepository<RoleServicePermissions,Long> {

    Optional<RoleServicePermissions> findByServiceName(String serviceName);

}
