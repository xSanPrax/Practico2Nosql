package com.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;  
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import java.util.UUID; 
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
