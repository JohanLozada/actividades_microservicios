package com.servicios.calculadora.controller;

import com.servicios.calculadora.services.InteCalculadoraServ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private final InteCalculadoraServ inteCalculadoraServ;
    public CalculadoraController(InteCalculadoraServ inteCalculadoraServ){
        this.inteCalculadoraServ = inteCalculadoraServ;
    }

    @GetMapping("/suma/{Vr1}/{Vr2}")
    public ResponseEntity getSuma(@PathVariable String num1, @PathVariable String num2){
        return inteCalculadoraServ.getSuma(num1, num2);
    }
    @GetMapping("/resta/{Vr1}/{Vr2}")
    public ResponseEntity getResta(@PathVariable String num1, @PathVariable String num2){
        return inteCalculadoraServ.getResta(num1, num2);
    }
    @GetMapping("/multiplicacion/{Vr1}/{Vr2}")
    public ResponseEntity getMultiplicacion(@PathVariable String num1, @PathVariable String num2){
        return inteCalculadoraServ.getMultiplicacion(num1, num2);
    }
    @GetMapping("/division/{Vr1}/{Vr2}")
    public ResponseEntity getDivision(@PathVariable String num1, @PathVariable String num2){
        return inteCalculadoraServ.getDivision(num1, num2);
    }
}