package de.testbase.service;

import de.testbase.domain.Address;
import de.testbase.domain.Person;
import de.testbase.repository.PersonRepository;
import de.testbase.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.Date;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    private void loadData() throws ParseException {
        personRepository.deleteAll();

        Date birthDate = DateUtils.getDate("1969-09-30 00:00:00", DateUtils.DB_FORMAT_DATETIME);
        Person person = new Person("Sören", "Ehm", birthDate, "info@soeren-ehm.de");

        Address address = new Address("Friedrichshulder Weg 23", "25469", "Halstenbek");
        person.add(address);
        personRepository.save(person);

        birthDate = DateUtils.getDate("1970-01-01 00:00:00", DateUtils.DB_FORMAT_DATETIME);
        person = new Person("Max", "Mustermann", birthDate, "info@max-mustermann.de");
        personRepository.save(person);
    }

    public Person getPersonByLastName(String lastName) throws Exception {
        Person person = personRepository.findByLastNameIgnoreCase(lastName);
        if (person == null) {
            throw new Exception(String.format("No person with lastname %s found.", lastName));
        }
        return person;
    }

    public Person getPersonByLastNameAndBirthYear(String lastName, int birthYear) throws ParseException {

        Date startDate = DateUtils.getDate(birthYear + "-01-01 00:00:00", DateUtils.DB_FORMAT_DATETIME);
        Date endDate = DateUtils.getDate(birthYear + "-12-31 24:00:00", DateUtils.DB_FORMAT_DATETIME);
        return personRepository.findByLastNameAndBirthYear(lastName, startDate, endDate);
    }

}
