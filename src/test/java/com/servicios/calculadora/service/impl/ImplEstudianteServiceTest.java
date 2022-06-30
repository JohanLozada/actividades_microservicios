package com.servicios.calculadora.service.impl;

import com.servicios.calculadora.model.EstudianteEntity;
import com.servicios.calculadora.repository.EstudianteRepository;
import com.servicios.calculadora.sample.EstudianteDTOSample;
import com.servicios.calculadora.sample.EstudianteEntitySample;
import com.servicios.calculadora.services.IEstudianteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ImplEstudianteServiceTest {

    @MockBean
    EstudianteRepository estudianteRepository;

    @Autowired
    IEstudianteService iEstudianteService;

    @Test
    void guardarEstudiante(){
        when(estudianteRepository.save(any())).thenReturn(EstudianteEntitySample.getEstudianteEntityTest());
        var responseEntity = iEstudianteService.guardarEstudiante(EstudianteDTOSample.getRequestEstudianteDTO());
        EstudianteEntity estudianteEntity = (EstudianteEntity) responseEntity.getBody();
        verify(estudianteRepository, times(1)).save(any());
        assertNotNull(estudianteEntity);
        assertEquals("juan", estudianteEntity.getNombre());
        assertInstanceOf(EstudianteEntity.class, estudianteEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void getAllEstudiantes(){
        when(estudianteRepository.findAll()).thenReturn(EstudianteEntitySample.getListEstudianteEntityTest());
        var responseEntity = iEstudianteService.getAllEstudiantes();
        List<EstudianteEntity> listAllEstudiantes = (List<EstudianteEntity>) responseEntity.getBody();
        verify(estudianteRepository,times(1)).findAll();
        assertNotNull(listAllEstudiantes);
        assertEquals(2,listAllEstudiantes.size());
        assertEquals("juan",listAllEstudiantes.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }

}
