package com.pweb.pw_api_u3_ab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.pw_api_u3_ab.repository.IEstudianteRepository;
import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        
        return this.estudianteRepository.seleccionarPorcedula(cedula);
    }

  


    
}
