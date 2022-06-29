package com.servicios.calculadora.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicios.calculadora.controller.v1.EstudianteController;
import com.servicios.calculadora.sample.EstudianteDTOSample;
import com.servicios.calculadora.sample.EstudianteEntitySample;
import com.servicios.calculadora.services.IEstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstudianteController.class)
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    IEstudianteService iEstudianteService;

    @Test
    void guardarEstudiante() throws  Exception{
        when(iEstudianteService.guardarEstudiante(any())).thenReturn(EstudianteEntitySample.getResponseEstudianteEntity());

        mvc.perform(post("/estudiante")
                        .content(objectToJson(EstudianteDTOSample.getRequestEstudianteDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));

        verify(iEstudianteService).guardarEstudiante(any());
    }


    public static String objectToJson(final Object object){
        try{
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
