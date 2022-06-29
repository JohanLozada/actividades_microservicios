package com.servicios.calculadora.controller.v1;

import com.servicios.calculadora.dto.EstudianteDTO;
import com.servicios.calculadora.model.EstudianteEntity;
import com.servicios.calculadora.services.IEstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@AllArgsConstructor
@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private IEstudianteService iEstudianteService;

    @PostMapping
    public ResponseEntity guardarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        return iEstudianteService.guardarEstudiante(estudianteDTO);
    }

    @GetMapping("/get-all-estudiantes")
    public ResponseEntity getAllEstudiantes(){
        return iEstudianteService.getAllEstudiantes();
    }

    @GetMapping("/nombre/native-query/{nombre}")
    public ResponseEntity getEstudianteNativeQuery(@PathVariable String nombre){
        return iEstudianteService.getEstudianteNativeQuery(nombre);
    }

    @GetMapping("/nombre/jpql/{nombre}")
    public ResponseEntity getEstudianteForJPQL(@PathVariable String nombre){
        return iEstudianteService.getEstudianteJPQL(nombre);
    }

    @GetMapping("/nombre/jpa-repository/{nombre}")
    public ResponseEntity getEstudianteForJPARepository(@PathVariable String nombre){
        return iEstudianteService.getEstudianteJpaRepository(nombre);
    }

    @GetMapping("/estudiante-id/native-query/{id}")
    public ResponseEntity getEstudianteIdNativeQuery(@PathVariable String id){
        return iEstudianteService.getEstudianteIdNativeQuery(id);
    }

    @GetMapping("/estudiante-id/jpql{id}")
    public ResponseEntity getEstudianteIdJPQL(@PathVariable String id){
        return iEstudianteService.getEstudianteIdJPQL(id);
    }

    @GetMapping("/estudiante-id/jpa-repository/{id}")
    public ResponseEntity getEstudianteIdJpaRepository(String id){
        return  iEstudianteService.getEstudianteIdJpaRepository(id);
    }

    @GetMapping("/fecha-creacion/native-query/{fecha}")
    public ResponseEntity getFechaNativeQuery(@PathVariable String fecha){
        return iEstudianteService.getFechaNativeQuery(fecha);
    }

    @GetMapping("/fecha-creacion/jpql/{año}/{mes}/{dia}")
    public ResponseEntity getFechaJPQL( String año, @PathVariable String mes, @PathVariable String dia){
        return iEstudianteService.getFechaJPQL(año, mes, dia);
    }

    @GetMapping("/fecha-creacion/jpa-repository/{año}/{mes}/{dia}")
    public  ResponseEntity getFechaJpaRepository(@PathVariable String año, @PathVariable String mes, @PathVariable String dia){
        return iEstudianteService.getFechaJpaRepository(año, mes, dia);
    }

    @PutMapping("/actualizar-estudiante{id}")
    public ResponseEntity putEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO){
        return iEstudianteService.putEstudiante(id, estudianteDTO);
    }

    @DeleteMapping("/delete-estudiante/{id}")
    public ResponseEntity deleteHard(@PathVariable Long id){
        return iEstudianteService.deleteHard(id);
    }

    @DeleteMapping("/delete-logic-estudiante/{id}")
    public ResponseEntity deleteLogic(@PathVariable Long id){
        return iEstudianteService.deleteLogic(id);
    }
}
