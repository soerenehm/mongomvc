package de.testbase.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Document(collection = "persons")
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String eMail;
    private Set<Address> addresses = new HashSet<>();

    public Person (String firstname, String lastname, Date birthDate, String eMail) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthDate = birthDate;
        this.eMail = eMail;
    }

    public void add(Address address) {
        Assert.notNull(address, "Adress must be filled");
        this.addresses.add(address);
    }

    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(addresses);
    }
}
