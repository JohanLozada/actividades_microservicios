package com.servicios.calculadora.services;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface InteCalcuCientServ {

    ResponseEntity getFactorial(String numero);

    ResponseEntity getMultiplo(String numero);

    ResponseEntity getCoseno(String numero);

    ResponseEntity getRaizCuadrada(String numero);

    ResponseEntity getRadioCirculo(String numero);

}
