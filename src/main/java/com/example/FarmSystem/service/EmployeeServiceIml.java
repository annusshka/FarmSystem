package com.example.FarmSystem.service;

import com.example.FarmSystem.models.Employee;
import com.example.FarmSystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    //private final EmployeeMapper employeeMapper;

    /*
    @Override
    public List<EmployeeDto> findAll() {
        return employeeMapper.toListDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto findById(Long id) {
        return Optional.of(getById(id)).map(employeeMapper::employeeToDto).get();
    }

    @Override
    @Transactional
    public EmployeeDto save(EmployeeDto employeeDto) {
        return employeeMapper.employeeToDto(employeeRepository.save(
                employeeMapper.dtoToEmployee(employeeDto)));
    }

     */

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return Optional.of(getById(id)).get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var employee = getById(id);
        employeeRepository.delete(employee);
    }

    private Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Employee with id: " + id + " not found"));
    }
}
