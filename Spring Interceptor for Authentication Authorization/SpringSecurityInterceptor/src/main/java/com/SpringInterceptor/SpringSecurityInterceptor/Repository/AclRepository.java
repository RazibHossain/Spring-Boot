package com.SpringInterceptor.SpringSecurityInterceptor.Repository;

import com.SpringInterceptor.SpringSecurityInterceptor.Entity.AclEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface AclRepository extends JpaRepository<AclEntity, Long> {

    @Query("from AclEntity acl where acl.url = ?1 and acl.role in (?2)")
    List<AclEntity> getByUrlAndRoles(String requestedUrl, List<String> roles);
}
