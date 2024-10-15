package com.hospital.entity;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Column;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Table("pacientes") // Asegúrate de que este nombre coincida con la tabla en Cassandra
@Getter
@Setter
public class Paciente {

    @PrimaryKey // Cambia a PrimaryKey en lugar de Id
    private String id; // Cambia el tipo de Long a String si usas UUID

    @Column("cedula")
    private String cedula;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("fechaNacimiento")
    private Date fechaNacimiento; // Cambia a Date o LocalDate para Cassandra

    @Column("sexo")
    private String sexo;
}
