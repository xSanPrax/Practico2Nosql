package com.hospital.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Table("registrosmedicos") // Asegúrate de que el nombre coincida con la tabla en Cassandra
@Getter
@Setter
public class RegistroMedico {

    @PrimaryKey
    private String id; // UUID es compatible con Cassandra

    @Column("fecha") // Si la fecha es un String en la base de datos, mantén este tipo
    private String fecha;

    @Column("tipo")
    private String tipo;

    @Column("diagnostico")
    private String diagnostico;

    @Column("medico")
    private String medico;

    @Column("institucion")
    private String institucion;

    @Column("descripcion")
    private String descripcion;

    @Column("medicacion")
    private String medicacion;

    @Column("cedula")
    private String cedula;
}
