package com.example.springboottutorial.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springboottutorial.model.Person;

public interface PersonDao {
    int addPerson(UUID id, Person name);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();

        return addPerson(id, person);

    }

    List<Person> selectAllPeople();

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    Optional<Person> selectPersonById (UUID id);
}
