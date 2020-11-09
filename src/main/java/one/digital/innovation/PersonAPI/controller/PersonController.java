package one.digital.innovation.PersonAPI.controller;

import one.digital.innovation.PersonAPI.entity.Person;
import one.digital.innovation.PersonAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> getPearson(){
        return personService.findAll();
    }


}
