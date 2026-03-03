package com.sena.test.IRepository.ISecurityRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.Security.UserRole;

public interface IUserRoleRepository extends JpaRepository <UserRole, Long> {

}