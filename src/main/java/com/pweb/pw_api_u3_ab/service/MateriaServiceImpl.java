package com.pweb.pw_api_u3_ab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.pw_api_u3_ab.repository.IMateriaRepository;
import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public Materia seleccionarPorCodigo(String codigo) {
       
        return this.materiaRepository.seleccionarPorCodigo(codigo);
    }

    @Override
    public void guardar(Materia materia) {
        
        this.materiaRepository.insertar(materia);
    }
}





