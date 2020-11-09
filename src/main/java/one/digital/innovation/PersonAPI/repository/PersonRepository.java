package one.digital.innovation.PersonAPI.repository;

import one.digital.innovation.PersonAPI.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
