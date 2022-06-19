package com.servicios.calculadora.repository;

import com.servicios.calculadora.model.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface EstudianteRepository  extends JpaRepository<EstudianteEntity,Long> {

    @Query(value = "SELECT u.* FROM estudiante u WHERE u.nombre = :nombre",nativeQuery = true)
    List<EstudianteEntity> buscarPorNombreEstudiante(String nombre);

    @Query("SELECT u FROM EstudianteEntity u WHERE u.nombre = :nombre")
    List<EstudianteEntity> buscarPorNombreEstudianteJPQL(String nombre);

    List<EstudianteEntity> findByNombre(String nombre);

    @Query(value = "SELECT u.* FROM estudiante u WHERE U.fecha_creacion = :fecha",nativeQuery = true)
    List<EstudianteEntity> buscarPorFechaEstudiante(String fecha);

    @Query("SELECT u FROM EstudianteEntity u WHERE u.fecha = :fecha")
    List<EstudianteEntity> buscarPorFechaJPQL(Date fecha);

    List<EstudianteEntity> findByFechaCreacion(Date fecha);
}
