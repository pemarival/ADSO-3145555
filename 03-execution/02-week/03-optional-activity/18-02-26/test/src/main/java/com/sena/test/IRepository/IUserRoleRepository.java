package com.sena.test.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.UserRole;

public interface IUserRoleRepository extends JpaRepository <UserRole, Long> {

}