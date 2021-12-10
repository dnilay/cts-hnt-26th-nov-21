package com.example.mongoapp.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Data
public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
