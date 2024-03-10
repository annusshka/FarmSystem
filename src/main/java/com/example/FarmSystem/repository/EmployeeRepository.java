package com.example.FarmSystem.repository;

import com.example.FarmSystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getEmployeeById(Long id);
}

