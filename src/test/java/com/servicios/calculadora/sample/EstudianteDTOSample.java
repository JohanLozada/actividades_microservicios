package com.servicios.calculadora.sample;

import com.servicios.calculadora.dto.EstudianteDTO;

public class EstudianteDTOSample {

    public static EstudianteDTO getRequestEstudianteDTO(){
        return new EstudianteDTO("juan", "rodriguez");
    }
}
