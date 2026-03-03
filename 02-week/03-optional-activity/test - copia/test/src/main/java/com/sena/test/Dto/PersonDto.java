package com.sena.test.Dto;

public class PersonDto {

    private Long idPerson;
    private String firstName;
    private String lastName;
    private String email;

    public PersonDto() {
    }

    public PersonDto(Long idPerson, String firstName, String lastName, String email) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}