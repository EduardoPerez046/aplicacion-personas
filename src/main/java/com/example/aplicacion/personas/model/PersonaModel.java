/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.personas.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 60, nullable = false, unique = true)
    private String nombre;
    @Column(name = "apellidos", length = 60, nullable = false)
    private String apellidos;
    @Column(name = "año_nacimiento", nullable = false)
    @Digits(integer = 4, fraction = 0, message = "El año de nacimiento debe contener solo números enteros")
    private int añoNacimiento;
    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;
    @Column(name = "telefono", nullable = false)
    @Digits(integer = 10, fraction = 0, message = "El teléfono debe contener solo números enteros")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;
    @Column(name = "correo", length = 60, nullable = false)
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String correo;
    @Column(name = "edad", nullable = false)
    private int edad ;
    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL)
    private List<HijoModel> hijos;

    public PersonaModel() {
    }

    /**
     * Constructor .
     * @param nombre El nombre de la persona.
     * @param apellidoP El apellido de la persona.
     * @param añoNacimiento El año de nacimiento de la persona.
     * @param direccion La dirección de la persona.
     * @param telefono El teléfono de la persona.
     * @param correo El correo electrónico de la persona.
     */
    
    public PersonaModel(String nombre, String apellidoP, int añoNacimiento, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidoP;
        this.añoNacimiento = añoNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        calcularEdad();
    }

    public void calcularEdad() {
        LocalDate fechaNacimiento = LocalDate.of(añoNacimiento, 1, 1); // Suponiendo que solo tienes el año de nacimiento
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        this.edad = periodo.getYears();
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
        calcularEdad();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<HijoModel> getHijos() {
        return hijos;
    }

    public void setHijos(List<HijoModel> hijos) {
        this.hijos = hijos;
    }
    
    
}
