package com.servicios.calculadora.controller.v1.v2;

import com.servicios.calculadora.controller.v1.v2.docs.EmployeeDocs;
import com.servicios.calculadora.services.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeerController  implements EmployeeDocs {

    private final IEmployeeService iEmployeeService;

    @GetMapping("/get-employees/{id}")
    public ResponseEntity getEmployees(Long id){
        return iEmployeeService.getEmployees(id);
    }

    @GetMapping("/list-employees-over-30")
    public ResponseEntity listEmployeesOver30(){
        return iEmployeeService.listEmployeesOver30();
    }

    @GetMapping("/list-employees-salary-100000")
    public  ResponseEntity listEmployeesSalary(){
        return iEmployeeService.listEmployeesSalary();
    }

    @GetMapping("/list-employees")
    public ResponseEntity listEmployees(){
        return iEmployeeService.listEmployees();
    }
}
