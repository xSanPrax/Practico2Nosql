package com.hospital.service;

import jakarta.persistence.EntityManager; 
import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger;
import com.hospital.entity.Paciente; 
import com.hospital.entity.RegistroMedico; 

public class ServicioNegocio {
    private EntityManager entityManager;
    private static final Logger logger = Logger.getLogger(ServicioNegocio.class.getName());

    public ServicioNegocio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void crearPaciente(Paciente paciente) {
        try {
            entityManager.persist(paciente);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear paciente: " + e.getMessage(), e);
        }
    }

    public List<Paciente> obtenerPacientes() {
        try {
            return entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener pacientes: " + e.getMessage(), e);
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }

    public void actualizarPaciente(Paciente paciente) {
        try {
            entityManager.merge(paciente);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar paciente: " + e.getMessage(), e);
        }
    }

    public void eliminarPaciente(Paciente paciente) {
        try {
            entityManager.remove(paciente);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al eliminar paciente: " + e.getMessage(), e);
        }
    }

    public void crearRegistroMedico(RegistroMedico registroMedico) {
        try {
            entityManager.persist(registroMedico);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear registro médico: " + e.getMessage(), e);
        }
    }

    public List<RegistroMedico> obtenerRegistrosMedicos() {
        try {
            return entityManager.createQuery("SELECT r FROM RegistroMedico r", RegistroMedico.class).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener registros médicos: " + e.getMessage(), e);
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }

    public void actualizarRegistroMedico(RegistroMedico registroMedico) {
        try {
            entityManager.merge(registroMedico);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar registro médico: " + e.getMessage(), e);
        }
    }

    public void eliminarRegistroMedico(RegistroMedico registroMedico) {
        try {
            entityManager.remove(registroMedico);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al eliminar registro médico: " + e.getMessage(), e);
        }
    }
}
