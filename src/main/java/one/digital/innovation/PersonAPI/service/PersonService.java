package one.digital.innovation.PersonAPI.service;

import lombok.AllArgsConstructor;
import one.digital.innovation.PersonAPI.DTO.request.PersonDTO;
import one.digital.innovation.PersonAPI.DTO.response.MessageResponseDTO;
import one.digital.innovation.PersonAPI.entity.Person;
import one.digital.innovation.PersonAPI.exceptions.PersonNotFoundException;
import one.digital.innovation.PersonAPI.mapper.PersonMapper;
import one.digital.innovation.PersonAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {
    @Autowired
    PersonMapper personMapper = PersonMapper.INSTANCE;
    @Autowired
    PersonRepository personRepository;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> findAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }


    public Person findbyId(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);
        return person;
    }

    public void updatePerson(Long id, PersonDTO personToUpdate) throws PersonNotFoundException {
        verifyIfExist(id);
        Person updatePerson = personMapper.toModel(personToUpdate);
        personRepository.save(updatePerson);
    }

    public Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
