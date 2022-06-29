package com.servicios.calculadora.services;

import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import org.springframework.http.ResponseEntity;

public interface IEstudianteService {

    ResponseEntity guardarEstudiante(EstudianteDTO estudianteDTO);

    ResponseEntity getAllEstudiantes();

    ResponseEntity getEstudianteNativeQuery(String nombre);

    ResponseEntity getEstudianteJPQL(String nombre);

    ResponseEntity getEstudianteJpaRepository(String nombre);

    ResponseEntity putEstudiante(Long id, EstudianteDTO estudianteDTO);

    ResponseEntity getEstudianteIdNativeQuery(String id);

    ResponseEntity getEstudianteIdJPQL(String id);

    ResponseEntity getEstudianteIdJpaRepository(String id);

    ResponseEntity getFechaNativeQuery(String fecha);

    ResponseEntity getFechaJPQL(String año, String mes, String dia);

    ResponseEntity getFechaJpaRepository(String año, String mes, String dia);

    ResponseEntity deleteHard(Long id);

    ResponseEntity deleteLogic(Long id);



}
