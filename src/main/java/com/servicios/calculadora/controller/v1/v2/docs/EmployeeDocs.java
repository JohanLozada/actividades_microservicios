package com.servicios.calculadora.controller.v1.v2.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.print.attribute.standard.Media;


@Tag(name = "filtro y listado de empleados")
public interface EmployeeDocs {

    @Operation(summary = "get employees")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Regresa empleado segun su id",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEmployees(@PathVariable Long id);

    @Operation(summary = "get list employees over 30")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Regresa lista de empleados mayor a 30",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listEmployeesOver30();

    @Operation(summary = "get list employees Salary 100000")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "regresa lista de empleados con salario mayor a 100000",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listEmployeesSalary();

    @Operation(summary = "get list employees")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "regresa lista de empleados",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listEmployees();

}
