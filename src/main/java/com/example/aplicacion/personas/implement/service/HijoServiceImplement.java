/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.personas.implement.service;

import com.example.aplicacion.personas.exception.PersonaNotFoundException;
import com.example.aplicacion.personas.model.HijoModel;
import com.example.aplicacion.personas.model.PersonaModel;
import com.example.aplicacion.personas.repository.HijoRepository;
import com.example.aplicacion.personas.repository.PersonaRepository;
import com.example.aplicacion.personas.service.HijoService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class HijoServiceImplement implements HijoService {

     @Autowired
    private HijoRepository hijoRepository;
    @Autowired
    private PersonaRepository personaRepository;
     
    // Crear un nuevo hijo
    @Override
    public void createHijo(HijoModel hijo) {
        Optional<HijoModel> existingHijo = hijoRepository.findByNombre(hijo.getNombre());
        if (existingHijo.isPresent()) {
            throw new PersonaNotFoundException("El nombre '" + hijo.getNombre() + "' ya está en uso");
        } else {
            hijoRepository.save(hijo);
        }
    }

    // Obtener todos los hijos
    @Override
    public List<HijoModel> getHijos() {
        return hijoRepository.findAll();
    }

    // Obtener hijo por ID
    @Override
    public HijoModel getHijoById(Long id) {
        Optional<HijoModel> hijoOptional = hijoRepository.findById(id);
        if (hijoOptional.isPresent()) {
            return hijoOptional.get();
        } else {
            // Si no se encuentra el hijo con el ID proporcionado, lanzar una excepción
            throw new PersonaNotFoundException("No se encontró el hijo con el ID proporcionado: " + id);
        }
    }
    
    // Actualizar hijo
    @Override
    public void updateHijo(HijoModel hijoModel, Long id) {
        Optional<HijoModel> hijoOptional = hijoRepository.findById(id);
        if (hijoOptional.isPresent()) { // Verifica si el hijo existe
            HijoModel existingHijo = hijoOptional.get();
            existingHijo.setNombre(hijoModel.getNombre());
            existingHijo.setEdad(hijoModel.getEdad());
            try {
                hijoRepository.save(existingHijo); // Guarda el hijo actualizado
            } catch (Exception e) {
                // Maneja la excepción
                throw new RuntimeException("Error al actualizar al hijo: " + e.getMessage());
            }
        } else {
            // Si no se encuentra el hijo con el ID proporcionado, lanzar una excepción
            throw new PersonaNotFoundException("No se encontró el hijo con el ID proporcionado: " + id);
        }
    }

    // Eliminar hijo
    @Override
    public void deleteHijo(Long id) {
        try {
            hijoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            // Si no se encuentra el hijo con el ID proporcionado, lanzar una excepción
            throw new PersonaNotFoundException("No se encontró el hijo con el ID proporcionado: " + id);
        }
    }

    // Filtrar hijos por persona
    @Override
    public List<HijoModel> getHijosByPersonaId(Long id) {
        return hijoRepository.findByPersonaIdNativeQuery(id);
        
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    
    @Transactional
    @Override
    public void insertarHijo(HijoModel hijoModel) {
        Optional<PersonaModel> personaOptional = personaRepository.findById(hijoModel.getIdPadre());
        if (personaOptional.isPresent()){
        String sql = "INSERT INTO public.hijo (nombre, edad, persona_id) VALUES (?, ?, ?)";
        entityManager.createNativeQuery(sql)
            .setParameter(1, hijoModel.getNombre())
            .setParameter(2, hijoModel.getEdad())
            .setParameter(3, hijoModel.getIdPadre())
            .executeUpdate();
        }
        else throw new PersonaNotFoundException("No se encontró la persona con el ID proporcionado: " + hijoModel.getIdPadre());
    }
    

}
