package com.hospital.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.hospital.entity.RegistroMedico; 
import java.util.UUID;

@Repository
public interface RegistroMedicoRepository extends CassandraRepository<RegistroMedico, String> {
}
