package com.sena.test.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userrole")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduserrole")
    private Long idUserRole;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idrole", nullable = false)
    private Role role;

    public UserRole() {
    }

    public UserRole(Long idUserRole, User user, Role role) {
        this.idUserRole = idUserRole;
        this.user = user;
        this.role = role;
    }

    public Long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Long idUserRole) {
        this.idUserRole = idUserRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}