/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.aplicacion.personas.repository;

import com.example.aplicacion.personas.model.PersonaModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface PersonaRepository extends JpaRepository<PersonaModel, Long>{

    Optional<PersonaModel> findByNombre(String nombre);
    Optional<PersonaModel> findById(Long id);
}
