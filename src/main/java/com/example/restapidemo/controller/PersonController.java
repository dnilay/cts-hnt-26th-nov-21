package com.example.restapidemo.controller;

import com.example.restapidemo.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonController {

    @GetMapping("/persons")
    public ResponseEntity<Person> getPerson()
    {
        return ResponseEntity.ok(Person.builder().firstName("John").lastName("Doe").email("john@email.com").build());
    }
}
