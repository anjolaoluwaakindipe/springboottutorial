package com.example.springboottutorial.dao;

import java.util.UUID;

import com.example.springboottutorial.model.Person;

public interface PersonDao {
    int insertPerson(UUID id, Person name);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();

        return insertPerson(id, person);

    }
}
