package com.example.demo.controller.person;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@ComponentScan(basePackages = {"com.example.demo.domain"})
@Controller
@EnableAutoConfiguration
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public String addPerson() {
        Person p = new Person("name", 100);
        personRepository.save(p);
        System.out.println(p.getName());

        List<Person> persons = personRepository.findByName(p.getName());
        System.out.println(persons);

        return "";
    }
}
