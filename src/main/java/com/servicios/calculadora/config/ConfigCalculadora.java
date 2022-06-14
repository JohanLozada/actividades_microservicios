package com.servicios.calculadora.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "servicios")
public class ConfigCalculadora {

    public static final String Suma = "variable1";

    public static final String Resta = "variable2";

    public static final String Multiplicacion = "variable3";

    public static final String Division = "variable4";

    public static final String Factorial = "variable5";

    public static final String Multiplos = "variable6";

    public static final String Raiz_cuadrada = "variable7";

    public static final String Coseno = "variable8";

    public static final String Radio_Circulo = "variable9";

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
