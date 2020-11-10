package one.digital.innovation.PersonAPI.controller;

import one.digital.innovation.PersonAPI.entity.Person;
import one.digital.innovation.PersonAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<Person> getPerson(){
        return personService.findAll();
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personService.findbyId(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void savePerson(@RequestBody Person personToSave){
        personService.save(personToSave);
  }

    @PostMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Person personToSave){
        personService.updatePerson(id, personToSave);
    }


}
