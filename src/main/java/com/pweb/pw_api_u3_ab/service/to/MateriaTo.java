package com.pweb.pw_api_u3_ab.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;




public class MateriaTo  extends RepresentationModel<MateriaTo> implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    private Integer id;

    private String nombre;

    private String numeroCodigo;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setNumeroCodigo(String numeroCodigo) {
        this.numeroCodigo = numeroCodigo;
    }

    

    
}
