package com.servicios.calculadora.services;

import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.dto.EstudianteLombokDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import org.springframework.http.ResponseEntity;

public interface IEstudianteService {

    ResponseEntity guardarEstudiante(EstudianteEntity estudianteEntity);

    ResponseEntity getEstudiantes();

    ResponseEntity getEstudianteNativeQuery(String nombre);

    ResponseEntity getEstudianteJPQL(String nombre);

    ResponseEntity getEstudianteJpaRepository(String nombre);

    ResponseEntity putEstudiante(EstudianteEntity estudianteEntity);

    ResponseEntity actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);

    ResponseEntity getFechaNativeQuery(String fecha);

    ResponseEntity getFechaJPQL(String a, String m, String d);

    ResponseEntity getFechaJpaRepository(String a, String m, String d);

    ResponseEntity deleteHard(Long id);

    ResponseEntity deleteLogic(Long id);

    ResponseEntity saveEstudiante(EstudianteLombokDTO estudianteLombokDTO);

}
