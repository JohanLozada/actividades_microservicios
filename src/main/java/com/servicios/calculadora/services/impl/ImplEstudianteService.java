package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.constants.AppConstants;
import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import com.servicios.calculadora.repository.EstudianteRepository;
import com.servicios.calculadora.services.IEstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.GregorianCalendar;

@AllArgsConstructor
@Service
class ImplEstudianteService implements IEstudianteService {

    private EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity guardarEstudiante(EstudianteDTO estudianteDTO) {
        var estudianteEntity = EstudianteEntity.builder()
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .fechaCreacion(new Date())
                .build();
        EstudianteEntity estudiante = estudianteRepository.save(estudianteEntity);
        return ResponseEntity.ok(estudiante);
    }

    @Override
    public ResponseEntity getAllEstudiantes() {
        return ResponseEntity.ok(estudianteRepository.findAll());
    }

    @Override
    public ResponseEntity getEstudianteNativeQuery(String nombre) {
        return ResponseEntity.ok(estudianteRepository.buscarPorNombreEstudiante(nombre));
    }

    @Override
    public ResponseEntity getEstudianteJPQL(String nombre) {
        return ResponseEntity.ok(estudianteRepository.buscarPorNombreEstudianteJPQL(nombre));
    }

    @Override
    public ResponseEntity getEstudianteJpaRepository(String nombre) {
        return ResponseEntity.ok(estudianteRepository.findByNombre(nombre));
    }

    @Override
    public ResponseEntity getEstudianteIdNativeQuery(String id){
        return ResponseEntity.ok(estudianteRepository.buscarPorIdEstudiante(id));
    }

    @Override
    public ResponseEntity getEstudianteIdJPQL(String id){
        return ResponseEntity.ok(estudianteRepository.buscarPorIdEstudianteJPQL((id)));
    }

    @Override
    public ResponseEntity getEstudianteIdJpaRepository(String id){
        return ResponseEntity.ok(estudianteRepository.findById(id));
    }

    @Override
    public ResponseEntity getFechaNativeQuery(String fecha){
        return ResponseEntity.ok(estudianteRepository.buscarPorFechaEstudiante(fecha));
    }

    @Override
    public ResponseEntity getFechaJPQL(String año, String mes, String dia){
        GregorianCalendar dateCalendar = new GregorianCalendar(Integer.parseInt(año), Integer.parseInt(mes)-1, Integer.parseInt(dia));
        Date fecha = dateCalendar.getTime();
        return ResponseEntity.ok(estudianteRepository.buscarPorFechaJPQL(fecha));
    }

    @Override
    public ResponseEntity getFechaJpaRepository(String año, String mes, String dia){
        GregorianCalendar dateCalendar = new GregorianCalendar(Integer.parseInt(año), Integer.parseInt(mes)-1, Integer.parseInt(dia));
        Date fecha = dateCalendar.getTime();
        return ResponseEntity.ok(estudianteRepository.findByFechaCreacion(fecha));

    }

    @Override
    public ResponseEntity putEstudiante(Long id, EstudianteDTO estudianteDTO) {
        var EstudianteOptional = estudianteRepository.findById(id);
        EstudianteEntity estudianteEntity = EstudianteOptional.get();
        estudianteEntity.setNombre(estudianteDTO.getNombre());
        estudianteEntity.setApellido(estudianteDTO.getApellido());
        estudianteRepository.save(estudianteEntity);
        return ResponseEntity.ok(AppConstants.ACTUALIZADO_EXITOSAMENTE);

    }

    @Override
    public ResponseEntity deleteHard(Long id) {
        var estudianteOptional = estudianteRepository.findById(id);
        estudianteRepository.delete(estudianteOptional.get());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity deleteLogic(Long id) {
        var estudiante = estudianteRepository.findById(id).get();
        estudiante.setFechaEliminacion(new Date());
        estudianteRepository.save(estudiante);
        return ResponseEntity.ok("Se ha eliminado el estudiante");
    }

}
