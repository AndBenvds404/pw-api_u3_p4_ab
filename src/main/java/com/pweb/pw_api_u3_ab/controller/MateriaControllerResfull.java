package com.pweb.pw_api_u3_ab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.pw_api_u3_ab.service.MateriaServiceImpl;
import com.pweb.pw_api_u3_ab.service.to.MateriaTo;

@CrossOrigin
@RestController
@RequestMapping(name = "/materias")
public class MateriaControllerResfull {

    @Autowired
    private MateriaServiceImpl materiaServiceImpl;

    @GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaTo>> buscarPorEstudiante(@PathVariable String cedula) {
        // las materias de un estudiante q es buscado por cedula
        return new ResponseEntity<List<MateriaTo>>(this.materiaServiceImpl.buscarPorCedulaEstudainte(cedula), null,
                220);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<MateriaTo> consultarPorId(@PathVariable Integer id) {
        MateriaTo materia = this.materiaServiceImpl.buscarMateriaPorId(id); // Link

        return new ResponseEntity<>(materia, null, 200);

    }

}
