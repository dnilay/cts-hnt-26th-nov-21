package com.example.mongoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    private  String addressLine1;
    private String addressLine2;
    private String city;
}
