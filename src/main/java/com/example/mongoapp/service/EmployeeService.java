package com.example.mongoapp.service;

import com.example.mongoapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);
    public List<Employee> fetchEmployees();
}
