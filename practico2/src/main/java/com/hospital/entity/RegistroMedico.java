package com.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;  
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import java.util.UUID; 
import java.sql.Timestamp; 
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "registrosmedicos")
public class RegistroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 36)
    private UUID id;

    @Column(name = "fecha", length = 10)
    private String fecha;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "diagnostico", length = 100)
    private String diagnostico;

    @Column(name = "medico", length = 50)
    private String medico;

    @Column(name = "institucion", length = 50)
    private String institucion;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "medicacion", length = 100)
    private String medicacion;

    @Column(name = "cedula", length = 20)
    private String cedula;

    // Getters y setters
}
