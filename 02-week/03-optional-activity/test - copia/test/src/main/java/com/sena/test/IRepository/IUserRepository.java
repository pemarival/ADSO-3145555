package com.sena.test.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.User;

public interface IUserRepository extends JpaRepository <User, Long> {

}