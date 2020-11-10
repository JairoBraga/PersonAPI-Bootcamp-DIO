package one.digital.innovation.PersonAPI.service;

import one.digital.innovation.PersonAPI.entity.Person;
import one.digital.innovation.PersonAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
       return personRepository.findAll();
    }


    public Optional<Person> findbyId(Long id){

        return personRepository.findById(id);
    }

    public void save(Person personToSave) {
        personRepository.save(personToSave);
    }

    public void updatePerson(Long id, Person personToUpdate) {
        personRepository.save(personToUpdate);
    }
}
