package com.hospital.repository;

import com.hospital.entity.RegistroMedico;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMedicoRepository extends CassandraRepository<RegistroMedico, String> {
    // Puedes definir métodos personalizados aquí si es necesario
}
