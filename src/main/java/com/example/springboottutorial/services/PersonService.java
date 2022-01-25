package com.example.springboottutorial.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springboottutorial.dao.PersonDao;
import com.example.springboottutorial.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final PersonDao personDao;

  @Autowired
  public PersonService(@Qualifier("fakeDAO") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person  person){
    return personDao.addPerson(person);
  }

  public List<Person> getAllPeople(){
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById (UUID id){
    return personDao.selectPersonById(id);
  }

  public int deletePerson (UUID id){
    return personDao.deletePersonById(id);
  }
}
