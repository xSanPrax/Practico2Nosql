package com.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.sql.Timestamp; // Agregar esta línea
import javax.persistence.ForeignKey;

@Entity
@Table(name = "pacientes")
public class Paciente {
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

    // Getters y setters
}
