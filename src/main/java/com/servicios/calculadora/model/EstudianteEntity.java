package com.servicios.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "estudiante")
public class EstudianteEntity implements Serializable {

    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column( name = "fecha_creacion")
    private Date fechaCreacion;

    @Column( name = "fecha_eliminacion")
    private Date fechaEliminacion;
}
