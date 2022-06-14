package com.servicios.calculadora.controller;

import com.servicios.calculadora.services.InteCalcuCientServ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora-cientifica")
public class CalculadoraCientController {

    private final InteCalcuCientServ inteCalcuCientServ;

    public CalculadoraCientController(InteCalcuCientServ inteCalcuCientServ){
        this.inteCalcuCientServ = inteCalcuCientServ;
    }

    @GetMapping("factorial/{numero}")
    public ResponseEntity getFactorial(@PathVariable String numero){
        return inteCalcuCientServ.getFactorial(numero);
    }

    @GetMapping("/multiplo/numero")
    public ResponseEntity getMultiplo(@PathVariable String numero){
        return inteCalcuCientServ.getMultiplo(numero);
    }

    @GetMapping("/coseno/{numero}")
    public  ResponseEntity getCoseno(@PathVariable String numero){
        return inteCalcuCientServ.getCoseno(numero);
    }

    @GetMapping("/raiz-cuadrada/{numero}")
    public ResponseEntity getRaizCuadrada(@PathVariable String numero){
        return inteCalcuCientServ.getRaizCuadrada(numero);
    }

    @GetMapping("/circulo/{radio}")
    public ResponseEntity getRadioCirculo(@PathVariable String numero){
        return inteCalcuCientServ.getRadioCirculo(numero);
    }
}
