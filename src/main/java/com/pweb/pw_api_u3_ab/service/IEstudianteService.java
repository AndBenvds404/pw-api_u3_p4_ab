package com.pweb.pw_api_u3_ab.service;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;

public interface IEstudianteService {

   public Estudiante seleccionarPorCedula(String cedula);

   public void guardar(Estudiante estudiante);

    
    
}
