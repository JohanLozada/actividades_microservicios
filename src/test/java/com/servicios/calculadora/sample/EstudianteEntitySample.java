package com.servicios.calculadora.sample;

import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstudianteEntitySample {

    public static ResponseEntity getResponseEstudianteEntity(){
        EstudianteEntity estudiante = new EstudianteEntity(1L, "juan", "rodriguez",new Date(), new Date());
        return ResponseEntity.ok(estudiante);
    }


    public static EstudianteEntity getEstudianteEntity(){
        EstudianteEntity estudianteEntity = EstudianteEntity.builder()
                .id(1L)
                .nombre("juan")
                .apellido("rodriguez")
                .fechaCreacion(new Date())
                .build();
        return estudianteEntity;
    }

    public static List<EstudianteEntity> getListEstudianteEntity(){
        return (List<EstudianteEntity>) getResponseListEstudianteEntity().getBody();
    }

    public static ResponseEntity getResponseListEstudianteEntity(){
        List<EstudianteEntity> estudianteEntityList = new ArrayList<>();
        EstudianteEntity estudiante = EstudianteEntity.builder()
                .id(1L)
                .nombre("juan")
                .apellido("rodriguez")
                .fechaCreacion(new Date())
                .build();
        estudianteEntityList.add(estudiante);
        return ResponseEntity.ok(estudianteEntityList);
    }

}

