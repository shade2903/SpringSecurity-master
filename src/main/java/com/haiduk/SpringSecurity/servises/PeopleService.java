package com.haiduk.SpringSecurity.servises;

import com.haiduk.SpringSecurity.models.Person;
import com.haiduk.SpringSecurity.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findOneByName(String name){
        return peopleRepository.findByUsername(name);
    }
}
