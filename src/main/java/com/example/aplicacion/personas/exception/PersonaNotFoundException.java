/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.personas.exception;

/**
 *
 * @author Admin
 */
public class PersonaNotFoundException extends RuntimeException {
    public PersonaNotFoundException(String mensaje) {
        super(mensaje);
        
    }
}
