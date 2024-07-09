package co.com.ps.c24a.service;

import co.com.ps.c24a.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getPersonById(Long id);
    List<Person> getPersonAll();
    Person savaPerson(Person person);
    Person updatePerson(Long id, Person person);
    void deletePerson(Long id);

}
