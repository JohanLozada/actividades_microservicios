package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.config.ConfigCalculadora;
import com.servicios.calculadora.services.InteSaludoServ;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public class SaludoServImpl implements InteSaludoServ{

    private final ConfigCalculadora configCalculadora;

    public SaludoServImpl(ConfigCalculadora configCalculadora){
        this.configCalculadora = configCalculadora;
    }

    @Override
    public ResponseEntity getSaludo(String hora){
        int horaNum = Integer.parseInt(hora);
        String mensaje;
        if(horaNum >= 6 && horaNum < 12){
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.Dia);
        } else if (horaNum >= 12 && horaNum < 19) {
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.Tarde);
        } else if (horaNum >= 19 && horaNum <= 23 || horaNum >= 0 && horaNum < 6){
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.Noche);
        }
        else{
            mensaje = "Error no valido";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getOperaciones(){
        String mensaje ="Operaciones disponibles:"+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Suma)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Resta)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Multiplicacion)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Division)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Factorial)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Multiplos)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Coseno)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Raiz_cuadrada)+
                "\n"+configCalculadora.getValoroperacion(ConfigCalculadora.Radio_Circulo);
        return ResponseEntity.ok(mensaje);
    }
}
