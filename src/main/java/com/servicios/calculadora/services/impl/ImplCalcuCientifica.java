package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.services.InteCalcuCientServ;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public class ImplCalcuCientifica implements InteCalcuCientServ {

    @Value("${multiplo.numero}")
    private int valorMaximo;

    public ResponseEntity getFactorial(String numero){
        String mensaje;
        int num1 = Integer.parseInt(numero);
        int resultado =1;
        for (int i=num1; i >=2; i--){
            resultado *= i;
        }
        mensaje = numero +" != "+ resultado;
        return ResponseEntity.ok(mensaje);
    }

    public ResponseEntity getMultiplo(String numero){
        String mensaje= "";
        double num1 = Double.parseDouble(numero);
        double i = Double.parseDouble(String.valueOf(valorMaximo));
        double resultado = num1 * i;
        mensaje += num1+" * "+" = "+resultado;
        return ResponseEntity.ok(mensaje);
    }

    public ResponseEntity getCoseno(String numero){
        String mensaje;
        double num1 = Math.toRadians(Double.parseDouble(numero));
        double resultado = Math.cos(num1);
        mensaje = "cos("+numero+") ="+ String.format("%.2f",resultado);
        return ResponseEntity.ok(mensaje);
    }

    public ResponseEntity getRaizCuadrada(String numero){
        double num1 = Math.sqrt(Double.parseDouble(numero));
        double num2 = '\u221A';
        double resultado = num2 + num1;
        return ResponseEntity.ok(resultado);
    }

    public ResponseEntity getRadioCirculo(String radio){
        double area = Math.PI;
        double resultado = area * (Math.pow(Double.parseDouble(radio),2));
        return ResponseEntity.ok(resultado);
    }


}
