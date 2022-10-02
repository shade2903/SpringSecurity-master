package com.haiduk.SpringSecurity.util;

import com.haiduk.SpringSecurity.models.Person;
import com.haiduk.SpringSecurity.servises.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;
@Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (peopleService.findOneByName(person.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "This full name is already taken");
        }
    }
}
