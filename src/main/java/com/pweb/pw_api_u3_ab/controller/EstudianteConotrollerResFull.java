package com.pweb.pw_api_u3_ab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    //GET
    @GetMapping(path="/{cedula}",produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula){
        
         //return this.estudianteService.seleccionarPorCedula(cedula);
         return ResponseEntity.status(227).body(this.estudianteService.seleccionarPorCedula(cedula));
           
    }

    //post y get

    @PostMapping(path = "/buscarDevolver", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String consultarDevolder(@RequestBody Estudiante estudiante){
        return this.estudianteService.guardarDevolver(estudiante);
    }

    //ejemplo
     @GetMapping(path="/status/{cedula}") //no se debe colorcar status ()
    
    public ResponseEntity<Estudiante> consultarPorCedulaStatusEj(@PathVariable String cedula){
        
         //return this.estudianteService.seleccionarPorCedula(cedula);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.estudianteService.seleccionarPorCedula(cedula));
           
    }

    @GetMapping(path="/statusResponse/{cedula}") //no se debe colorcar status ()
    @ResponseStatus(HttpStatus.CONFLICT)
    public Estudiante consultarPorCedulaStatus(@PathVariable String cedula){
        
         //return this.estudianteService.seleccionarPorCedula(cedula);
         return this.estudianteService.seleccionarPorCedula(cedula);
           
    }



    @PostMapping(consumes = "application/xml")
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);

    }

    @PutMapping(path = "/{identificador}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador ){
        
        estudiante.setId(identificador);
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador){
         
        estudiante.setId(identificador);
        String cedula ="1227093001";
        Estudiante estudiante2 =this.estudianteService.seleccionarPorCedula(cedula);
       
        estudiante2.setCedula(estudiante.getCedula());
        this.estudianteService.actualizarParcial(cedula, cedula);

    }

    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id){
        this.estudianteService.eliminar(id);
    }
    

    //buscar todos y devolver una lista
    @GetMapping(path = "/buscarTodos")
        public ResponseEntity <List<Estudiante>> buscarTodos(){
            
        //return this.estudianteService.buscarTodos();
            HttpHeaders cabecera = new HttpHeaders();
            cabecera.add("DetalleMensaje", "Ciudadano consultado Exitosamente"); //(identificador, contenido )
            cabecera.add("valorApi", "Incalculable");
        return new ResponseEntity<List<Estudiante>>(this.estudianteService.buscarTodos(), cabecera, 228);
    }

    @GetMapping(path = "/buscarTodosProvincia")
        public List<Estudiante> buscarProvincia(@RequestParam String provincia){
        return this.estudianteService.buscarTodosProvincia(provincia);
    }
}
