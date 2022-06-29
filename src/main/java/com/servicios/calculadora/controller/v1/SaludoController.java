package com.servicios.calculadora.controller.v1;

import com.servicios.calculadora.services.InteSaludoServ;
import com.servicios.calculadora.services.impl.SaludoServImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bienvenido")
public class SaludoController {

    private final InteSaludoServ inteSaludoServ;

    public SaludoController(InteSaludoServ inteSaludoServ){
        this.inteSaludoServ = inteSaludoServ;
    }

    @GetMapping("/saludo{hora}")
    public ResponseEntity getSaludo(@PathVariable String hora){
        return inteSaludoServ.getSaludo(hora);
    }

    @GetMapping("/operaciones")
    public ResponseEntity getOperaciones(){
        return inteSaludoServ.getOperaciones();
    }

}
