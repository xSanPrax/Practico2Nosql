package com.hospital.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.hospital.entity.Paciente; 
import com.hospital.entity.RegistroMedico; 
import com.hospital.exception.PacienteNotFoundException;
import com.hospital.repository.PacienteRepository;
import com.hospital.repository.RegistroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.repository.PacienteRepository;

@Service
public class ServicioNegocio {
    private final PacienteRepository pacienteRepository;
    private final RegistroMedicoRepository registroMedicoRepository;
    private static final Logger logger = Logger.getLogger(ServicioNegocio.class.getName());

    @Autowired
    public ServicioNegocio(PacienteRepository pacienteRepository, RegistroMedicoRepository registroMedicoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.registroMedicoRepository = registroMedicoRepository;
    }

    // Métodos de manejo de Paciente
    public void crearPaciente(Paciente paciente) {
        try {
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear paciente: " + e.getMessage(), e);
        }
    }

    public List<Paciente> obtenerPacientes() {
        try {
            return pacienteRepository.findAll();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener pacientes: " + e.getMessage(), e);
            return List.of(); // Retorna una lista vacía en caso de error
        }
        
    }

//    public void actualizarPaciente(Long id, Paciente paciente) {
//        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
//        if (pacienteOptional.isPresent()) {
//            Paciente existingPaciente = pacienteOptional.get();
//            // Actualiza las propiedades necesarias
//            existingPaciente.setNombre(paciente.getNombre());
//            existingPaciente.setApellido(paciente.getApellido());
//            pacienteRepository.save(existingPaciente);
//        } else {
//            throw new PacienteNotFoundException("Paciente no encontrado");
//        }
//    }


//    public void eliminarPaciente(Long id) {
//        try {
//            Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
//            if (pacienteOptional.isPresent()) {
//                pacienteRepository.deleteById(id);
//            } else {
//                throw new PacienteNotFoundException("Paciente no encontrado");
//            }
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al eliminar paciente: " + e.getMessage(), e);
//            throw new RuntimeException("No se pudo eliminar el paciente");
//        }
//    }
//
//    // Métodos de manejo de Registro Médico
//    public void crearRegistroMedico(RegistroMedico registroMedico) {
//        try {
//            registroMedicoRepository.save(registroMedico);
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al crear registro médico: " + e.getMessage(), e);
//        }
//    }
//
//    public List<RegistroMedico> obtenerRegistrosMedicos() {
//        try {
//            return registroMedicoRepository.findAll();
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al obtener registros médicos: " + e.getMessage(), e);
//            return List.of(); // Retorna una lista vacía en caso de error
//        }
//    }
//
//    public void actualizarRegistroMedico(RegistroMedico registroMedico) {
//        try {
//            registroMedicoRepository.save(registroMedico);
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al actualizar registro médico: " + e.getMessage(), e);
//        }
//    }
//
//    public void eliminarRegistroMedico(Long id) {
//        try {
//            registroMedicoRepository.deleteById(id);
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al eliminar registro médico: " + e.getMessage(), e);
//        }
//    }
}
