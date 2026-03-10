package com.sena.test.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.Person;

public interface IPersonRepository extends JpaRepository <Person, Long> {

}


