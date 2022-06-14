package com.servicios.calculadora.services;

import org.springframework.http.ResponseEntity;

public interface InteSaludoServ  {

    ResponseEntity getSaludo(String hora);

    ResponseEntity getOperaciones();
}
