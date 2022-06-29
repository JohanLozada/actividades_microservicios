package com.servicios.calculadora.providers;


import com.servicios.calculadora.dto.api.dummy.ResponseBodyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "restapiexample",
        url = "${restapiexample.url}"
)
public interface EmployeeFeingProvider {

    @GetMapping("/employees")
    ResponseBodyDTO getlistEmployee();

    @GetMapping("/employee/{id}")
    ResponseBodyDTO getEmployee(@PathVariable Long id);
}
