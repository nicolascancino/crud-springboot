package com.nicolascancino.crud.repository;

import com.nicolascancino.crud.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, String> {
}
