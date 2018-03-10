package de.testbase;

import de.testbase.domain.Address;
import de.testbase.domain.Person;
import de.testbase.repository.PersonRepository;
import de.testbase.service.PersonService;
import de.testbase.util.DateUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class MongoMockitoTests {

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    private Person person;
    private Address address;

    @Before
    public void init() throws Exception {
        person = new Person(
                "Sören", "Ehm",
                DateUtils.getDate("1969-09-30 00:00:00", DateUtils.DB_FORMAT_DATETIME),
                "info@soeren-ehm.de");
    }

    @Test
    public void personalFoundByLastName() throws Exception {
        when(personRepository.findByLastNameIgnoreCase("ehm")).thenReturn(person);
        assertEquals("Ehm", personService.getPersonByLastName("ehm").getLastName());
    }

    @Test
    public void personalNotFoundByLastNameThrowException() throws Exception {
        thrownException.expect(Exception.class);
        thrownException.expectMessage(String.format("No person with lastname %s found.", "unknown"));

        when(personRepository.findByLastNameIgnoreCase("ehm")).thenReturn(person);
        String lastName = personService.getPersonByLastName("unknown").getLastName();
    }
}
