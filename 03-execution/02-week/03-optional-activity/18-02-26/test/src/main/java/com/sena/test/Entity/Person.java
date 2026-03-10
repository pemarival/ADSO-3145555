package com.sena.test.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private Long idPerson;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @OneToMany(mappedBy = "person")
    private List<User> users;

    public Person() {
    }

    public Person(Long idPerson, String firstName, String lastName, String email, List<User> users) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}