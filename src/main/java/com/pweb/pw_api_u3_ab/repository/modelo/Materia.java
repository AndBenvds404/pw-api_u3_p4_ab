package com.pweb.pw_api_u3_ab.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
    
     @Id
	@Column(name = "mate_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mate_seq_id")
	@SequenceGenerator(name = "mate_seq_id", sequenceName = "mate_seq_id", allocationSize = 1)
	private Integer id;

    @Column(name = "mate_nombre")
    private String nombre;

    @Column(name = "mate_num_codigo")
    String numeroCodigo;
    @Column(name = "mate_creditos")
    String creditos;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    

    //Set and Get

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
