package com.sena.test.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"role\"")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrole")
    private Long idRole;

    @Column(name = "rolename", nullable = false, length = 50)
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public Role() {
    }

    public Role(Long idRole, String roleName, List<UserRole> userRoles) {
        this.idRole = idRole;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}