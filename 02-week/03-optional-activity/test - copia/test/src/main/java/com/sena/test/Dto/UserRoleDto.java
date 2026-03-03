package com.sena.test.Dto;

public class UserRoleDto {

    private Long idUserRole;
    private Long idUser;
    private Long idRole;

    public UserRoleDto() {
    }

    public UserRoleDto(Long idUserRole, Long idUser, Long idRole) {
        this.idUserRole = idUserRole;
        this.idUser = idUser;
        this.idRole = idRole;
    }

    public Long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Long idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

}