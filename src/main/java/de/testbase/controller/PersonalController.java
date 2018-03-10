package de.testbase.controller;

import de.testbase.domain.Person;
import de.testbase.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class PersonalController {

    private PersonService personService;

    @Autowired
    public PersonalController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String personal(Model model) throws Exception {
        return personalRef("Ehm", model);
    }

    @RequestMapping("/persoenlich/{lastName}")
    public String personal(@PathVariable("lastName") String lastName, Model model) throws Exception {
        Person person = personService.getPersonByLastName(lastName);
        model.addAttribute("person", person);
        return "persoenlich";
    }

    @RequestMapping("/persoenlich/{lastName}/filter")
    public String personal(@PathVariable("lastName") String lastName, @RequestParam(value = "year")  int birthYear, Model model) throws ParseException {
        Person person = personService.getPersonByLastNameAndBirthYear(lastName, birthYear);
        model.addAttribute("person", person);
        return "persoenlich";
    }

    @RequestMapping("/{lastName}")
    public String personalRef(@PathVariable("lastName") String lastName, Model model) throws Exception {
        Person person = personService.getPersonByLastName(lastName);
        model.addAttribute("person", person);
        return "persoenlich";
    }
}
