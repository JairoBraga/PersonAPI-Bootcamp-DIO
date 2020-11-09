package one.digital.innovation.PersonAPI.service;

import one.digital.innovation.PersonAPI.entity.Person;
import one.digital.innovation.PersonAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll(){
       return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findbyId(@PathVariable Long id){

        return personRepository.findById(id);
    }
}
