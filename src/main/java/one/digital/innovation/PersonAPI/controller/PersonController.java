package one.digital.innovation.PersonAPI.controller;

import one.digital.innovation.PersonAPI.DTO.request.PersonDTO;
import one.digital.innovation.PersonAPI.entity.Person;
import one.digital.innovation.PersonAPI.exceptions.PersonNotFoundException;
import one.digital.innovation.PersonAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<PersonDTO> getPerson(){

        return personService.findAll();
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findbyId(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void savePerson(@RequestBody PersonDTO personToSave){
        personService.createPerson(personToSave);
  }

    @PostMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody PersonDTO personToSave) throws PersonNotFoundException {
        personService.updatePerson(id, personToSave);
    }


}
