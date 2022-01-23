package com.example.springboottutorial.api;

import java.util.List;

import com.example.springboottutorial.model.Person;
import com.example.springboottutorial.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
  private final PersonService personService;
  
  @Autowired
  public PersonController(PersonService personService){
    this.personService = personService;
  }

  @PostMapping
  public int addPerson(@RequestBody Person person){
    return personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPeople(){
    return personService.getAllPeople();
  }
  
}
