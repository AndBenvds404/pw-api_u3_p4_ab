package com.pweb.pw_api_u3_ab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.pw_api_u3_ab.repository.Estudiante;
import com.pweb.pw_api_u3_ab.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteConotrollerResFull {

    @Autowired
    private IEstudianteService estudianteService;

    public Estudiante consultarPorCedula(){
        String cedula = "17273839";
        return this.estudianteService.seleccionarPorcedula(cedula);
    }
    
}
