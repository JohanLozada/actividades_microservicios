package com.servicios.calculadora.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "estudiante")
public class EstudianteEntity implements Serializable {

    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;

    public EstudianteEntity() {

    }

    public EstudianteEntity(Long id, String nombre, String apellido, Date fechaCreacion, Date fechaEliminacion){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCreacion = fechaCreacion;
        this.fechaEliminacion = fechaEliminacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public Date getFechaCreacion(){
        return  fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEliminacion(){
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }
}
