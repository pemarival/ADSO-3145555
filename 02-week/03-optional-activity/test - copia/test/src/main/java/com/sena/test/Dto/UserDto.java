package com.sena.test.Dto;

public class UserDto {

    private Long idUser;
    private String userName;
    private String password;
    private Long idPerson;

    public UserDto() {
    }

    public UserDto(Long idUser, String userName, String password, Long idPerson) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.idPerson = idPerson;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

}