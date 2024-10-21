package com.hospital.entity;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Column;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate; 

@Table("pacientes") // Nombre de la tabla en Cassandra
@Getter
@Setter
public class Paciente {

    @PrimaryKey
    private String id; // UUID o String para Cassandra

    @Column("cedula")
    private String cedula;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("fecha_nacimiento") // Nombre de la columna en Cassandra
    private LocalDate fechaNacimiento; // O usa Date si prefieres

    @Column("sexo")
    private String sexo;
}
