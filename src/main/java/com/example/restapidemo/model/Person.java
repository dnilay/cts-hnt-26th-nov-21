package com.example.restapidemo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private String email;
}
