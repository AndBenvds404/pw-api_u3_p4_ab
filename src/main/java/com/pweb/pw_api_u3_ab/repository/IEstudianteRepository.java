package com.pweb.pw_api_u3_ab.repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    
    public Estudiante seleccionarPorcedula(String cedula);
}
