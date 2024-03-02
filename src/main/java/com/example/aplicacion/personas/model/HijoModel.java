/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.personas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "hijo")
public class HijoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 60)
    private String nombre;
    @Column(name = "edad", length = 60)
    private int edad;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaModel padre;

    private Long idPadre;
    public HijoModel() {
    }

    public HijoModel(String nombre, int edad, Long idPadre) {
        this.nombre = nombre;
        this.edad = edad;    
        this.idPadre=idPadre;
    }

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }
  

    public void setPadre(PersonaModel padre) {
        this.padre = padre;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
