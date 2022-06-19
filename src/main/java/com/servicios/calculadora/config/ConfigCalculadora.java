package com.servicios.calculadora.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "servicios")
public class ConfigCalculadora {

    public static final String Suma = "suma";

    public static final String Resta = "resta";

    public static final String Multiplicacion = "multiplicacion";

    public static final String Division = "division";

    public static final String Factorial = "factorial";

    public static final String Multiplos = "multiplos";

    public static final String Raiz_cuadrada = "raiz";

    public static final String Coseno = "coseno";

    public static final String Radio_Circulo = "radio";

    public static final String Dia = "mañana";

    public static final String Tarde = "tarde";

    public static final String Noche = "Noche";

    private Map<String, String> calculadora;

    private Map<String, String> saludo;

    public String getValoroperacion(String operacion){
        return calculadora.get(operacion);
    }
    public String getValorSaludo(String hora){
        return saludo.get(hora);
    }

    public Map<String, String> getCalculadora(){
        return calculadora;
    }

    public void setCalculadora(Map<String, String> calculadora) {
        this.calculadora = calculadora;
    }

    public Map<String, String> getSaludo() {
        return saludo;
    }

    public void setSaludo(Map<String, String> saludo){
        this.saludo = saludo;
    }


}
