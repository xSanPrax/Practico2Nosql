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
    public ResponseEntity<Void> crearPaciente(@RequestBody Paciente paciente) {
        try {
            servicioNegocio.crearPaciente(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear paciente: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("No se pudo crear el paciente"); // Devuelve un error 500
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerPacientes() {
        try {
            List<Paciente> pacientes = servicioNegocio.obtenerPacientes();
            return ResponseEntity.ok(pacientes); // 200 OK
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener pacientes: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("No se pudo obtener la lista de pacientes"); // Devuelve un error 500
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        try {
            paciente.setId(id); // Asignar ID al paciente
            servicioNegocio.actualizarPaciente(paciente);
            return ResponseEntity.ok().build(); // 200 OK
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar paciente: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("No se pudo actualizar el paciente"); // Devuelve un error 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        try {
            servicioNegocio.eliminarPaciente(id); // Asume que este método elimina por ID
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al eliminar paciente: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("No se pudo eliminar el paciente"); // Devuelve un error 500
        }
    }
}
