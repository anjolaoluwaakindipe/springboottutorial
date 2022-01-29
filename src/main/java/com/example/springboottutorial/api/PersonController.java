package com.example.springboottutorial.api;

import com.example.springboottutorial.model.Person;
import com.example.springboottutorial.service.PersonService;


public class PersonController {
    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
