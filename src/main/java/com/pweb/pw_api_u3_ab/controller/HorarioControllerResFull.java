package com.pweb.pw_api_u3_ab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.pw_api_u3_ab.repository.modelo.Horario;
import com.pweb.pw_api_u3_ab.service.IHorarioService;


@RestController
@RequestMapping("/horarios")
public class HorarioControllerResFull {



    @Autowired
    private IHorarioService horarioService;

    @GetMapping(path="/{codigo}")
    public Horario consultarPorCodigo(@PathVariable String codigo){
         return this.horarioService.seleccionarPorCodigo(codigo);
           
    }


    @PostMapping
    public void guardar(@RequestBody Horario horario){
        this.horarioService.guardar(horario);

    }

    /*  {
    "duracion": "180h",
    "nivel": "c01",
    "periodo": "octavo",
    "turno": "vespertino",
    "codigo": "1234"
} */

    @PutMapping(path = "/{identificador}")
    public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador ){
        
        horario.setId(identificador);
        this.horarioService.actualizar(horario);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador){
         
        horario.setId(identificador);
        String codigo ="1236";
        Horario horario2 =this.horarioService.seleccionarPorCodigo(codigo);
       
        horario2.setCodigo(horario.getCodigo());
        this.horarioService.actualizar(horario2);

    }

    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id){
        this.horarioService.eliminar(id);
    }
    
}
