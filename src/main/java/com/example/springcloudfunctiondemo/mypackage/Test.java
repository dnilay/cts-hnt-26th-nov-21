package com.example.springcloudfunctiondemo.mypackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


public class Test implements Function<String,String> {
    @Override
    public String apply(String s) {
        return "Hello : "+s;
    }
}
