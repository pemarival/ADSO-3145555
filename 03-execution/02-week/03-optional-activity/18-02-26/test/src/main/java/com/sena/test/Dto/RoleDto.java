package com.sena.test.Dto;

public class RoleDto {

    private Long idRole;
    private String roleName;

    public RoleDto() {
    }

    public RoleDto(Long idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
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

}