package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.dto.api.dummy.ResponseBodyDTO;
import com.servicios.calculadora.dto.api.dummy.ResponseEmployeeDTO;
import com.servicios.calculadora.providers.EmployeeFeingProvider;
import com.servicios.calculadora.services.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplEmployee  implements IEmployeeService {

    private final EmployeeFeingProvider employeeFeingProvider;

    @Override
    public ResponseEntity getEmployees(Long id){
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try {
            responseBodyDTO = employeeFeingProvider.getEmployee(id);
            response = ResponseEntity.ok(responseBodyDTO);
        }catch (Exception e){
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public  ResponseEntity listEmployeesOver30(){
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try{
            responseBodyDTO = employeeFeingProvider.getlistEmployee();
            List<ResponseEmployeeDTO> Employees = responseBodyDTO.getData();
            List<ResponseEmployeeDTO> Over30 = new ArrayList<>();
            for (ResponseEmployeeDTO i:Employees){
                if (i.getEmployeeAge() >30L){
                    Over30.add(i);
                }
            }
            response = ResponseEntity.ok(Over30);
        }catch (Exception e){
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public ResponseEntity listEmployeesSalary(){
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try {
            responseBodyDTO = employeeFeingProvider.getlistEmployee();
            List<ResponseEmployeeDTO> Employees = responseBodyDTO
                    .getData()
                    .stream()
                    .filter(i->i.getEmployeeSalary()>100000)
                    .collect(Collectors.toList());
            response = ResponseEntity.ok(listEmployeesSalary());
        }catch (Exception e){
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public ResponseEntity listEmployees(){
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try {
            responseBodyDTO = employeeFeingProvider.getlistEmployee();
            response = ResponseEntity.ok(responseBodyDTO);
        }catch (Exception e){
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

}
