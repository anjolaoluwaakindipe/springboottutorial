package com.example.springboottutorial.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springboottutorial.model.Person;

import org.springframework.stereotype.Repository;

/**
 * FakePersonDataAccessService
 */
@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDao { 
    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }

        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        return DB.stream().filter(person -> person.getId().equals(id) ).findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        // TODO Auto-generated method stub
        return selectPersonById(id).map(person ->{
            int indexOfPersonToDelete = DB.indexOf(person);
            if (indexOfPersonToDelete >= 0){
                DB.set(indexOfPersonToDelete, new Person(id, update.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    private static List<Person>  DB = new ArrayList<Person>();

    @Override
    public int addPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }
    
}