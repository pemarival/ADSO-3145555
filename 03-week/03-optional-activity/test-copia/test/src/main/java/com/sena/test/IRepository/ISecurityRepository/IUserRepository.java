package com.sena.test.IRepository.ISecurityRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.Security.User;

public interface IUserRepository extends JpaRepository <User, Long> {

}