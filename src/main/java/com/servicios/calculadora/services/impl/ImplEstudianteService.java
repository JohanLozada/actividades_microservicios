package com.servicios.calculadora.services.impl;

import com.servicios.calculadora.constants.AppConstants;
import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.dto.EstudianteLombokDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import com.servicios.calculadora.repository.EstudianteRepository;
import com.servicios.calculadora.services.IEstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;

@Service
class ImplEstudianteService implements IEstudianteService {

    private EstudianteRepository estudianteRepository;

    public ImplEstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public ResponseEntity guardarEstudiante(EstudianteEntity estudianteEntity){
        estudianteEntity.setFechaCreacion(new Date());
        EstudianteEntity estudiante = estudianteRepository.save(estudianteEntity);
        return ResponseEntity.ok(estudiante);
    }

    @Override
    public ResponseEntity getEstudiantes() {
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
    public ResponseEntity putEstudiante(EstudianteEntity estudianteEntity) {
        EstudianteEntity estudiante = estudianteRepository.findById(estudianteEntity.getId()).orElse(new EstudianteEntity());
        estudiante.setNombre(estudianteEntity.getNombre());
        estudiante.setApellido(estudianteEntity.getApellido());
        estudianteRepository.save(estudiante);
        return ResponseEntity.ok("Ha sido actualizado");
    }

    @Override
    public ResponseEntity getFechaNativeQuery(String fecha){
        return ResponseEntity.ok(estudianteRepository.buscarPorFechaEstudiante(fecha));
    }

    @Override
    public ResponseEntity getFechaJPQL(String a, String m, String d){
        GregorianCalendar fechaCalend = new GregorianCalendar(Integer.parseInt(a), Integer.parseInt(m)-1, Integer.parseInt(d));
        Date fecha = fechaCalend.getTime();
        return ResponseEntity.ok(estudianteRepository.buscarPorFechaJPQL(fecha));
    }

    @Override
    public ResponseEntity getFechaJpaRepository(String a, String m, String d){
        GregorianCalendar fechacalend = new GregorianCalendar(Integer.parseInt(a), Integer.parseInt(m)-1, Integer.parseInt(d));
        Date fecha = fechacalend.getTime();
        return ResponseEntity.ok(estudianteRepository.findByFechaCreacion(fecha));

    }

    @Override
    public ResponseEntity actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
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

    @Override
    public ResponseEntity saveEstudiante(EstudianteLombokDTO estudianteLombokDTO){
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setNombre(estudianteLombokDTO.getNombre());
        estudiante.setFechaCreacion(new Date());
        estudiante = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(estudiante);
    }

}
