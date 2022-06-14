package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.services.InteCalculadoraServ;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public class ImplCalculadora implements InteCalculadoraServ {

    public ResponseEntity getSuma(String num1, String num2){
        double numeros1 = Double.parseDouble(num1);
        double numeros2 = Double.parseDouble(num2);
        double resultado = numeros2 + numeros1;
        return ResponseEntity.ok(resultado);
    }

    public ResponseEntity getResta(String num1, String num2){
        double numeros1 = Double.parseDouble(num1);
        double numeros2 = Double.parseDouble(num1);
        double resultado = numeros1 - numeros2;
        return ResponseEntity.ok(resultado);
    }
    public ResponseEntity getMultiplicacion(String num1, String num2){
        double numeros1 = Double.parseDouble(num1);
        double numeros2 = Double.parseDouble(num2);
        double resultado = numeros1 * numeros2;
        return ResponseEntity.ok(resultado);
    }
    public ResponseEntity getDivision(String num1, String num2){
        double numeros1 = Double.parseDouble(num1);
        double numeros2 = Double.parseDouble(num2);
        double resultado = numeros1 / numeros2;
        return ResponseEntity.ok(resultado);
    }
}
