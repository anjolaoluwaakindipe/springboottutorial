package com.example.springboottutorial.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.springboottutorial.model.Person;

/**
 * FakePersonDataAccessService
 */
public class FakePersonDataAccessService implements PersonDao { 
    private static List<Person>  DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
    
}