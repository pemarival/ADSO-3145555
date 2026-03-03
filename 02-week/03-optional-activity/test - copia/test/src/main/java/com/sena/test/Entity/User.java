package com.sena.test.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long idUser;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idperson", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    public User() {
    }

    public User(Long idUser, String userName, String password, Person person, List<UserRole> userRoles) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.person = person;
        this.userRoles = userRoles;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}