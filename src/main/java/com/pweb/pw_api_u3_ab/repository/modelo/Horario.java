package com.pweb.pw_api_u3_ab.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {


    @Id
	@Column(name = "hora_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hora_seq_id")
	@SequenceGenerator(name = "hora_seq_id", sequenceName = "hora_seq_id", allocationSize = 1)
	private Integer id;

    @Column(name = "hora_duracion")
    private String duracion;

    @Column(name = "hora_nivel")
    private String nivel;

    @Column(name = "hora_periodo")
    private String periodo;

    @Column(name = "hora_turno")
    private String turno;

    @Column(name = "hora_codigo")
    private String codigo;


    //set and get
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

    
}
