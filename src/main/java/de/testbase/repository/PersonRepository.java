package de.testbase.repository;

import de.testbase.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;

public interface PersonRepository extends MongoRepository<Person, Long> {

    Person findByLastNameIgnoreCase(String lastName);

    // db.persons.find({lastName: 'Ehm', birthDate: {$gte: ISODate("1969-01-01 00:00:00"), $lte: ISODate("1969-12-31 24:00:00")}})
    @Query("{'lastName' : ?0, 'birthDate': {$gte: ?1, $lte: ?2}}")
    Person findByLastNameAndBirthYear(String lastName, Date startDate, Date endDate);
}
