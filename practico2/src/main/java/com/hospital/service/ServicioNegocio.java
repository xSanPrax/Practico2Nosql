package com.hospital.service;

import javax.persistence.EntityManager; 
import java.util.List; 
import com.hospital.entity.Paciente; 
import com.hospital.entity.RegistroMedico; 

public class ServicioNegocio {
    private EntityManager entityManager;

    public ServicioNegocio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void crearPaciente(Paciente paciente) {
        entityManager.persist(paciente);
    }

    public List<Paciente> obtenerPacientes() {
        return entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList(); //puede variar el returno xq nose como es por cassandra
    }

    public void actualizarPaciente(Paciente paciente) {
        entityManager.merge(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        entityManager.remove(paciente);
    }

    public void crearRegistroMedico(RegistroMedico registroMedico) {
        entityManager.persist(registroMedico);
    }

    public List<RegistroMedico> obtenerRegistrosMedicos() {
        return entityManager.createQuery("SELECT r FROM RegistroMedico r", RegistroMedico.class).getResultList(); //x2 xd
    }

    public void actualizarRegistroMedico(RegistroMedico registroMedico) {
        entityManager.merge(registroMedico);
    }

    public void eliminarRegistroMedico(RegistroMedico registroMedico) {
        entityManager.remove(registroMedico);
    }
}
