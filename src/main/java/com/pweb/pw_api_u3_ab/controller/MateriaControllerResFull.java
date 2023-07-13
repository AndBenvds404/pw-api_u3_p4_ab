package com.pweb.pw_api_u3_ab.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.pw_api_u3_ab.repository.modelo.Materia;
import com.pweb.pw_api_u3_ab.service.IMateriaService;


@RestController
@RequestMapping("/materias")
public class MateriaControllerResFull {

    private static final Logger logger = Logger.getLogger(MateriaControllerResFull.class.getName());

    @Autowired
    private IMateriaService materiaService;

    @GetMapping(path="/buscar")
    public Materia consultarPorcodigo(){
        String codigo = "ProgW001";
         var a=    this.materiaService.seleccionarPorCodigo(codigo);
         logger.info("debugeaaanddooooooooooooooooooooooooooo");
        return a;
   
    }


    @PostMapping(path = "/guardar")
    public void guardar(@RequestBody Materia materia){
        this.materiaService.guardar(materia);

    }

    
}
