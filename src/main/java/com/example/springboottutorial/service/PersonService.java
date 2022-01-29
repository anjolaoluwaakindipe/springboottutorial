package com.example.springboottutorial.service;

import com.example.springboottutorial.dao.PersonDao;
import com.example.springboottutorial.model.Person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        personDao.insertPerson(person);
        return 0;
    }
}
