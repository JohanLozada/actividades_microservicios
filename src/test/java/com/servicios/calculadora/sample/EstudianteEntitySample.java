package com.servicios.calculadora.sample;

import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstudianteEntitySample {

    public static ResponseEntity getEstudianteEntity(){
        EstudianteEntity estudiante = new EstudianteEntity(1L, "juan", "rodriguez",new Date(), new Date());
        return ResponseEntity.ok(estudiante);
    }


    public static EstudianteEntity getEstudianteEntityTest(){
        EstudianteEntity estudianteEntity = EstudianteEntity.builder()
                .id(1L)
                .nombre("juan")
                .apellido("rodriguez")
                .fechaCreacion(new Date())
                .build();
        return estudianteEntity;
    }

    public static List<EstudianteEntity> getListEstudianteEntityTest(){
        return (List<EstudianteEntity>) getListEstudianteEntity().getBody();
    }

    public static ResponseEntity getListEstudianteEntity(){
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

