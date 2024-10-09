package com.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Timestamp; 
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pacientes")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // Agregamos el campo id

    @Column(name = "cedula", length = 20)
    private String cedula;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "fechaNacimiento")
    private Timestamp fechaNacimiento;

    @Column(name = "sexo", length = 1)
    private String sexo;


}
