/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.aplicacion.personas.service;

import com.example.aplicacion.personas.model.PersonaModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PersonaService {
    public void createPersona(PersonaModel persona);
    
    public List getPersonas();
    public PersonaModel getPersonaById(Long id);
    public void updatePersona(PersonaModel PersonaModel, Long id);
    public void deletePersona(Long id);
}
