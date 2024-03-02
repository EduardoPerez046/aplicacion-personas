/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.aplicacion.personas.repository;

import com.example.aplicacion.personas.model.HijoModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface HijoRepository extends JpaRepository<HijoModel, Long>{

    // Método que utiliza una consulta nativa para buscar todos los hijos por su atributo persona_id
    @Query(value = "SELECT * FROM hijos WHERE persona_id = ?1", nativeQuery = true)
    List<HijoModel> findByPersonaIdNativeQuery(Long personaId);
    
    Optional<HijoModel> findByNombre(String nombre);
    Optional<HijoModel> findById(Long id);
}
