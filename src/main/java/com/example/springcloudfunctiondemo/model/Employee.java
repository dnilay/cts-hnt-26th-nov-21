package com.example.springcloudfunctiondemo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {

    private String firstName;
    private String lastName;
    private String email;

}
