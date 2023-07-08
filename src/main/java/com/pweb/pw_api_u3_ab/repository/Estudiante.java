package com.pweb.pw_api_u3_ab.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,  generator="seq_estudiante")
    @SequenceGenerator(name="estu_seq_id", sequenceName="estu_seq_id" , allocationSize = 1   )
    @Column(name="estu_id")
    private String id;
    public String nombre;
     @Column(name="estu_apellido")
    private String apellido;
     @Column(name="estu_fecha") 
    private String fechaNacimiento;
     @Column(name="estu_cedula")
    private String cedula;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    
}
