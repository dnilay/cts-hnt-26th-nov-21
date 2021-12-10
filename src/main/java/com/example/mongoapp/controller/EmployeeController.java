package com.example.mongoapp.controller;

import com.example.mongoapp.entity.Employee;
import com.example.mongoapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("employee-service is up");
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee)
    {

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/employees")
    public ResponseEntity<?> fetchEmployees()
    {
        return ResponseEntity.ok(employeeService.fetchEmployees());
    }
}
