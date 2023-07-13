package com.pweb.pw_api_u3_ab.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;
import com.pweb.pw_api_u3_ab.service.IEstudianteService;


@RestController
@RequestMapping("/estudiantes")
public class EstudianteConotrollerResFull {

    private static final Logger logger = Logger.getLogger(EstudianteConotrollerResFull.class.getName());

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping(path="/buscar")
    public Estudiante consultarPorCedula(){
        String cedula = "1727093";
         var a=    this.estudianteService.seleccionarPorCedula(cedula);
         logger.info("debugeaaanddooooooooooooooooooooooooooo");
        return a;
   
    }


    @PostMapping(path = "/guardar")
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);

    }

    @PutMapping(path = "/actualizar")
    public void actualizar(){

    }

    @PatchMapping(path = "/actualizarParcial")
    public void actualizarParcial(){

    }

    @DeleteMapping(path = "borrar")
    public void borrar(){

    }
    
}
