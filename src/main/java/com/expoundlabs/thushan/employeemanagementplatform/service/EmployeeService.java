package com.expoundlabs.thushan.employeemanagementplatform.service;


import com.expoundlabs.thushan.employeemanagementplatform.entity.Employee;
import com.expoundlabs.thushan.employeemanagementplatform.exception.UserNotFoundException;
import com.expoundlabs.thushan.employeemanagementplatform.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
//        employeeRepository.deleteById(id);
        employeeRepository.deleteEmployeeById(id);
    }

}
