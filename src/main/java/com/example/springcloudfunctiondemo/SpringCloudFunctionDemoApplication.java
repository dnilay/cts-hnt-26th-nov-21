package com.example.springcloudfunctiondemo;

import com.example.springcloudfunctiondemo.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringCloudFunctionDemoApplication {


    @Bean
    public Function<String,String> reverse() {
       return  (input)->new StringBuilder(input).reverse().toString();
    }
    @Bean
    public Supplier<List<Employee>> getEmployee() {
        return ()-> Stream.of(Employee.builder().firstName("John").lastName("Doe").email("john@email.com").build(),
                Employee.builder().firstName("Marry").lastName("Public").email("marry@email.com").build(),
                Employee.builder().firstName("Susan").lastName("Joseph").email("susan@email.com").build())
                .collect(Collectors.toList());
    }

    @Bean
    public Consumer<String> printMessage() {
        return (input) -> System.out.println(input);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionDemoApplication.class, args);
    }

}
