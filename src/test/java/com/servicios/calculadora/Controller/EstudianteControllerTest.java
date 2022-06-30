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
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstudianteController.class)
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    IEstudianteService iEstudianteService;

    @Test
    void guardarEstudiante() throws Exception {
        when(iEstudianteService.guardarEstudiante(any())).thenReturn(EstudianteEntitySample.getEstudianteEntity());

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

    @Test
    void getAllEstudiante() throws Exception {
        when(iEstudianteService.getAllEstudiantes()).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante/get-all-estudiante")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService).getAllEstudiantes();
    }

    @Test
    void getEstudianteNativeQuery() throws Exception {
        when(iEstudianteService.getEstudianteIdNativeQuery(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante/nombre/native-query/juan")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getEstudianteNativeQuery(anyString()));
    }

    @Test
    void getEstudianteJPQL() throws Exception {
        when(iEstudianteService.getEstudianteIdJPQL(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante/nombre/jpql/juan")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getEstudianteJPQL(anyString()));
    }

    @Test
    void getEstudianteJpaRepository() throws Exception {
        when(iEstudianteService.getEstudianteIdJpaRepository(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante/nombre/jpa-repository/juan")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getEstudianteNativeQuery(anyString()));
    }

    @Test
    void putEstudiante() throws Exception {
        when(iEstudianteService.putEstudiante(anyLong(), any())).thenReturn(ResponseEntity.ok("actializado exitosamente"));

        mvc.perform(put("/estudiante/actualizar-estudiante/id")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Se actualizo exitosamente"));
        verify(iEstudianteService.putEstudiante(anyLong(), any()));
    }

    @Test
    void getEstudianteIdNativeQuery() throws Exception{
        when(iEstudianteService.getEstudianteIdNativeQuery(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante/estudiante-id/native-query/id")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getEstudianteIdNativeQuery(anyString()));
    }

    @Test
    void getEstudianteIdJPQL() throws Exception{
        when(iEstudianteService.getEstudianteIdNativeQuery(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante-id/jpql/id")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getEstudianteIdJPQL(anyString()));
    }

    @Test
    void getEstudianteIdJpaRepository() throws Exception{
        when(iEstudianteService.getEstudianteIdJpaRepository(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/estudiante-id/jpa-repository/id")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getEstudianteIdJpaRepository(anyString()));
    }

    @Test
    void getFechaNativeQuery() throws Exception{
        when(iEstudianteService.getFechaNativeQuery(anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/fecha-creacion/native-query/fecha")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getFechaNativeQuery(anyString()));
    }

    @Test
    void getFechaJPQL() throws Exception{
        when(iEstudianteService.getFechaJPQL(anyString(), anyString(), anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/fecha-creacion/jpql/año/mes/dia")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getFechaJPQL(anyString(), anyString(), anyString()));
    }

    @Test
    void getFechaJpaRepository() throws Exception{
        when(iEstudianteService.getFechaJpaRepository(anyString(), anyString(), anyString())).thenReturn(EstudianteEntitySample.getListEstudianteEntity());

        mvc.perform(get("/fecha-creacion/jpa-repository/año/mes/dia")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("juan"))
                .andExpect(jsonPath("$.apellido").value("rodriguez"));
        verify(iEstudianteService.getFechaJPQL(anyString(), anyString(), anyString()));
    }

    @Test
    void deleteHard() throws Exception{
        when(iEstudianteService.deleteHard(anyLong())).thenReturn(ResponseEntity.ok().build());

        mvc.perform(delete("/delete-estudiante/id")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value(ResponseEntity.ok().build()));
        verify(iEstudianteService.deleteHard(anyLong()));
    }

    @Test
    void deleteLogic() throws  Exception{
        when(iEstudianteService.deleteHard(anyLong())).thenReturn(ResponseEntity.ok("Se ha eliminado el estudiante"));

        mvc.perform(delete("/delete-logic-estudiante/id")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Se ha eliminado el estudiante"));
        verify(iEstudianteService.deleteLogic(anyLong()));
    }

    public static String objectToJson(final Object object){
        try{
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
