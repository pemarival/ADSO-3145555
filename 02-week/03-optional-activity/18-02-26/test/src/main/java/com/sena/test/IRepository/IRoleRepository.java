package com.sena.test.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.Role;

public interface IRoleRepository extends JpaRepository <Role, Long> {

}