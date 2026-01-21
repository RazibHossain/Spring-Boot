package com.SpringInterceptor.SpringSecurityInterceptor.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "acl", schema = "aclinterceptor", catalog = "")
public class AclEntity {
    private Integer id;
    private String role;
    private String url;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AclEntity aclEntity = (AclEntity) o;
        return Objects.equals(id, aclEntity.id) &&
                Objects.equals(role, aclEntity.role) &&
                Objects.equals(url, aclEntity.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role, url);
    }
}
