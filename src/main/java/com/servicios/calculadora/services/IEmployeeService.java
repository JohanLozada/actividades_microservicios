package com.servicios.calculadora.services;

import org.springframework.http.ResponseEntity;

public interface IEmployeeService {

    ResponseEntity getEmployees(Long id);

    ResponseEntity listEmployeesOver30();

    ResponseEntity listEmployeesSalary();

    ResponseEntity listEmployees();

}
