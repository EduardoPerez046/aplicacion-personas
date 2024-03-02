/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.personas.controller;

import com.example.aplicacion.personas.exception.PersonaNotFoundException;
import com.example.aplicacion.personas.model.PersonaModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.aplicacion.personas.repository.PersonaRepository;
import com.example.aplicacion.personas.service.PersonaService;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    @Autowired
    private PersonaService personaService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> registrarPersona(@Valid @RequestBody PersonaModel persona) {
        personaService.createPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body("Persona creada satisfactoriamente");
    }

   

    @Transactional
    @GetMapping
    public ResponseEntity<List<PersonaModel>> getPersonas() {
        List<PersonaModel> personas = personaService.getPersonas();
        return ResponseEntity.ok(personas);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> getPersonaById(@PathVariable Long id) {
        PersonaModel persona = personaService.getPersonaById(id);
        return ResponseEntity.ok(persona);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody PersonaModel persona, @PathVariable Long id) {
        personaService.updatePersona(persona, id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }

    
}
