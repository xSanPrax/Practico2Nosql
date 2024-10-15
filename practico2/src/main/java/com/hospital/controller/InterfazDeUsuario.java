package com.hospital.controller;

import com.hospital.entity.Paciente; 
import com.hospital.service.ServicioNegocio;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pacientes") 
public class InterfazDeUsuario {
    private final ServicioNegocio servicioNegocio;
    private static final Logger logger = Logger.getLogger(InterfazDeUsuario.class.getName());

    public InterfazDeUsuario(ServicioNegocio servicioNegocio) {
        this.servicioNegocio = servicioNegocio;
    }

    @PostMapping
    public void crearPaciente(@RequestBody Paciente paciente) {
        try {
            servicioNegocio.crearPaciente(paciente);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear paciente: " + e.getMessage(), e);
            throw new RuntimeException("No se pudo crear el paciente"); // Opcional: lanza una excepción más amigable
        }
    }

    @GetMapping
    public List<Paciente> obtenerPacientes() {
        try {
            return servicioNegocio.obtenerPacientes();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener pacientes: " + e.getMessage(), e);
            throw new RuntimeException("No se pudo obtener la lista de pacientes"); // Opcional
        }
    }

//    @PutMapping("/{id}")
//    public void actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
//        try {
//            // Asignar ID al paciente antes de actualizar
//            servicioNegocio.actualizarPaciente(id, paciente); // Pasa el id y el objeto paciente
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al actualizar paciente: " + e.getMessage(), e);
//            throw new RuntimeException("No se pudo actualizar el paciente");
//        }
//    }
//
//
//    @DeleteMapping("/{id}")
//    public void eliminarPaciente(@PathVariable Long id) { // Cambiado a Long
//        try {
//            servicioNegocio.eliminarPaciente(id); // Pasa solo el ID
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al eliminar paciente: " + e.getMessage(), e);
//            throw new RuntimeException("No se pudo eliminar el paciente");
//        }
//    }
//




}
