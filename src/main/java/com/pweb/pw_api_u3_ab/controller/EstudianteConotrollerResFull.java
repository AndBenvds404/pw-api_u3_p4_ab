package com.pweb.pw_api_u3_ab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;
import com.pweb.pw_api_u3_ab.service.IEstudianteService;
/*
  {
    "nombre": "Andres Actualizado",
    "apellido": "Benavides",
    "fechaNacimiento": "1998-08-04T00:00:00",
    "cedula": "1727093003"
}
 */

@RestController
@RequestMapping("/estudiantes")
public class EstudianteConotrollerResFull {



    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping(path="/buscar/{cedula}")
    public Estudiante consultarPorCedula(@PathVariable String cedula){
        
         return this.estudianteService.seleccionarPorCedula(cedula);
        
   
    }


    @PostMapping(path = "/guardar")
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);

    }

    @PutMapping(path = "/actualizar/{identificador}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador ){
        
        estudiante.setId(identificador);
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path = "/actualizarParcial/{identificador}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador){
         
        estudiante.setId(identificador);
        String cedula ="1227093001";
        Estudiante estudiante2 =this.estudianteService.seleccionarPorCedula(cedula);
       
        estudiante2.setCedula(estudiante.getCedula());
        this.estudianteService.actualizar(estudiante2);

    }

    @DeleteMapping(path = "/borrar/{id}")
    public void borrar(@PathVariable Integer id){
        this.estudianteService.eliminar(id);
    }
    

    //buscar todos y devolver una lista

    @GetMapping(path = "/buscarTodos/{provincia}")
    public List<Estudiante> buscarTodos(@RequestParam String provincia){
        return this.estudianteService.buscarTodos(provincia);
    }
}
