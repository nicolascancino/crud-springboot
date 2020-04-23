package com.nicolascancino.crud.service;

import com.nicolascancino.crud.Entity.Person;
import com.nicolascancino.crud.controller.PeopleController;
import com.nicolascancino.crud.repository.PeopleRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public ResponseEntity<List<Person>> getAllPersonService(){
        List<Person> listPerson = peopleRepository.findAll();
        if(listPerson.size()>0){
            return  new ResponseEntity<>(listPerson, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Person> getPersonById(String id){
        Optional<Person> person = peopleRepository.findById(id);

        if(person.isPresent()){
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Person> createPersonService(Person newPerson){
        return new ResponseEntity<>(peopleRepository.save(newPerson), HttpStatus.CREATED);
    }
    public ResponseEntity<?> deletePersonService(String id){
        try {
            peopleRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Person> updatePersonService(Person person){
        if(!peopleRepository.findById(person.getRut()).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(peopleRepository.save(person), HttpStatus.OK);
    }
}
