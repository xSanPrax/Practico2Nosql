package com.hospital.repository;

import com.hospital.entity.Paciente;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CassandraRepository<Paciente, String> {
    // Métodos adicionales si es necesario
}
