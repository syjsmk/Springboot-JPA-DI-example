package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    @Query("select name from Person where height > 50")
    List<Person> findByHeightMoreThan50(String name);
}
