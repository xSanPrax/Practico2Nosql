package com.hospital.controller;

import com.hospital.entity.Paciente; 
import com.hospital.service.ServicioNegocio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes") 
public class InterfazDeUsuario {
    private final ServicioNegocio servicioNegocio;

    public InterfazDeUsuario(ServicioNegocio servicioNegocio) {
        this.servicioNegocio = servicioNegocio;
    }

    @PostMapping
    public void crearPaciente(@RequestBody Paciente paciente) {
        servicioNegocio.crearPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> obtenerPacientes() {
        return servicioNegocio.obtenerPacientes();
    }

    @PutMapping("/{id}")
    public void actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        // Asignar ID al paciente antes de actualizar (si es necesario)
        paciente.setId(id); // Asegúrate de que el método setId exista en la clase Paciente
        servicioNegocio.actualizarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        // Se asume que existe un método en ServicioNegocio para encontrar al paciente por ID
        Paciente paciente = servicioNegocio.obtenerPacientes().stream()
                .filter(p -> p.getId().equals(id)) // Verifica si el paciente existe
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        
        servicioNegocio.eliminarPaciente(paciente);
    }
}
