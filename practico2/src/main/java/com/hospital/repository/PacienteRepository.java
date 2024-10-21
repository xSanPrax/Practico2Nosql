package com.hospital.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.hospital.entity.Paciente;  

@Repository
public interface PacienteRepository extends CassandraRepository<Paciente, String> {
}
