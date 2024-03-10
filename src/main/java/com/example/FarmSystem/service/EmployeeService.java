package com.example.FarmSystem.service;

import com.example.FarmSystem.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee save(Employee employee);
    void deleteById(Long id);
}
