package com.example.demo.controller.person;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonRepository;
import com.example.demo.domain.Phone;
import com.example.demo.domain.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@ComponentScan(basePackages = {"com.example.demo.domain"})
@Controller
@EnableAutoConfiguration
public class PersonController {

    private PersonRepository personRepository;
    private PhoneRepository phoneRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, PhoneRepository phoneRepository) {
        this.personRepository = personRepository;
        this.phoneRepository = phoneRepository;
    }

    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public String addPerson() {
        Person p1 = new Person("name1", 100);
        Person p2 = new Person("name2", 20);

        Phone ph1 = new Phone("name1", "000");
        System.out.println(ph1.getName());
        System.out.println(ph1.getNumber());
        phoneRepository.save(ph1);

        List<Phone> phones = new ArrayList<Phone>();
        phones.add(ph1);
        p1.setPhone(phones);

        personRepository.save(p1);
        System.out.println(p1.getName());


        List<Person> persons = personRepository.findByName(p1.getName());
        System.out.println(persons);
        persons.forEach(person -> person.getPhone().forEach(phone -> {
            System.out.println(phone.getNumber());
        }));

        persons = personRepository.findByHeightMoreThan50(p2.getName());
        System.out.println(persons);

        return "";
    }
}
