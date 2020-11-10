package one.digital.innovation.PersonAPI.mapper;

import one.digital.innovation.PersonAPI.DTO.request.PersonDTO;
import one.digital.innovation.PersonAPI.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel="spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}

