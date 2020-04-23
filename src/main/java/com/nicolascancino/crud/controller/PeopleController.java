package com.nicolascancino.crud.controller;

import com.nicolascancino.crud.Entity.Person;
import com.nicolascancino.crud.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/v1")
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/health")
    public ResponseEntity<?> getHealth(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAllPerson() {
        return peopleService.getAllPersonService();
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id){
        return peopleService.getPersonById(id);
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person newPerson){
        return peopleService.createPersonService(newPerson);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable String id){
        return peopleService.deletePersonService(id);
    }

    @PutMapping("/people")
    public ResponseEntity<Person> updatePerson(@RequestBody Person newPerson){
        return peopleService.updatePersonService(newPerson);
    }
}
