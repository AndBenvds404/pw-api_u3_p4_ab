package com.pweb.pw_api_u3_ab.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="materia")
public class Materia {
    

    @Id
	@Column(name = "mate_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mate_seq_id")
	@SequenceGenerator(name = "mate_seq_id", sequenceName = "mate_seq_id", allocationSize = 1)
	private Integer id;

    @Column(name = "mate_nombre")
    private String nombre;

    @Column(name = "mate_creditos")
    private Integer credeitos;

    @Column(name = "mate_horas")
    private String horas;

    @Column(name = "mate_codigo")
    private String codigo;


    //sets and gets

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

    public Integer getCredeitos() {
        return credeitos;
    }

    public void setCredeitos(Integer credeitos) {
        this.credeitos = credeitos;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

  
    

}