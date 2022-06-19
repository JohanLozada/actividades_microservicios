package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.config.ConfigCalculadora;
import com.servicios.calculadora.services.InteSaludoServ;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;

@Service
public class SaludoServImpl implements InteSaludoServ {

    private final ConfigCalculadora configCalculadora;

    public SaludoServImpl(ConfigCalculadora configCalculadora) {
        this.configCalculadora = configCalculadora;
    }

    @Override
    public ResponseEntity getSaludo(String hora) {
        int horaNum = Integer.parseInt(hora);
        String mensaje;
        if (horaNum >= 6 && horaNum < 12) {
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.Dia);
        } else if (horaNum >= 12 && horaNum < 19) {
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.Tarde);
        } else if (horaNum >= 19 && horaNum <= 23 || horaNum >= 0 && horaNum < 6) {
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.Noche);
        } else {
            mensaje = "Error no valido";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getOperaciones() {
        String mensaje = "Operaciones disponibles:";
        ArrayList<String> listadoOperaciones = new ArrayList<>(configCalculadora.getCalculadora().values());
        for (String i : listadoOperaciones) {
            mensaje += "\n" + i;
        }
        return ResponseEntity.ok(mensaje);
    }
}
