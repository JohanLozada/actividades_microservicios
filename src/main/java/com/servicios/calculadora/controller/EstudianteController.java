package com.servicios.calculadora.controller;

import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import com.servicios.calculadora.services.IEstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private IEstudianteService iEstudianteService;

    public EstudianteController(IEstudianteService iEstudianteService){
        this.iEstudianteService = iEstudianteService;
    }

    @PostMapping
    public ResponseEntity guardarEstudiante(@RequestBody EstudianteEntity estudianteEntity){
        return iEstudianteService.guardarEstudiante(estudianteEntity);
    }

    @GetMapping
    public ResponseEntity getEstudiantes(){
        return iEstudianteService.getEstudiantes();
    }

    @GetMapping("/nombre/native-query")
    public ResponseEntity getEstudianteNativeQuery(@PathParam("nombre") String nombre){
        return iEstudianteService.getEstudianteNativeQuery(nombre);
    }

    @GetMapping("/nombre/jpql")
    public ResponseEntity getEstudianteForJPQL(@PathParam("nombre") String nombre){
        return iEstudianteService.getEstudianteJPQL(nombre);
    }

    @GetMapping("/nombre/jpa-repository")
    public ResponseEntity getEstudianteForJPARepository(@PathParam("nombre") String nombre){
        return iEstudianteService.getEstudianteJpaRepository(nombre);
    }

    @GetMapping("/fecha/native-query")
    public ResponseEntity getFechaNativeQuery(@PathParam("fecha") String fecha){
        return iEstudianteService.getFechaNativeQuery(fecha);
    }

    @PutMapping
    public ResponseEntity putEstudiante(@RequestBody EstudianteEntity estudianteEntity){
        return iEstudianteService.putEstudiante(estudianteEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarEstudiante(@PathVariable Long id, @PathVariable EstudianteDTO estudiante){
        return iEstudianteService.actualizarEstudiante(id, estudiante);
    }

    @DeleteMapping("/logic/{id}")
    public ResponseEntity deleteHard(@PathVariable Long id){
        return iEstudianteService.deleteLogic(id);
    }
}
