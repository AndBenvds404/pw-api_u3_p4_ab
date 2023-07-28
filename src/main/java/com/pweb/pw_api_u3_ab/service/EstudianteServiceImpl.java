package com.pweb.pw_api_u3_ab.service;

import java.util.List;
import java.util.stream.Collector;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.pw_api_u3_ab.repository.IEstudianteRepository;
import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;
import com.pweb.pw_api_u3_ab.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
       
        return this.estudianteRepository.seleccionarPorcedula(cedula);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        
        this.estudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
       
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        
        this.estudianteRepository.borrar(id);
    }

    @Override
    public List<Estudiante> buscarTodosProvincia(String provincia) {
        return this.estudianteRepository.buscarTodosProvincia(provincia);
    }

    @Override
    public List<Estudiante> buscarTodos() {
        
        return this.estudianteRepository.buscarTodos();
    }

    @Override
    public void actualizarParcial(String cedula, String nuevaCedula) {
        this.estudianteRepository.actualizarParcial(cedula, nuevaCedula);
    }

    @Override
    public Estudiante guardarDevolver(Estudiante estudiante) {
        
        return this.estudianteRepository.insertarDevolver(estudiante);
    }

    @Override
    public List<EstudianteTO> buscarTodosHateoas() {
        
        List<Estudiante> lista = this.estudianteRepository.buscarTodos();
        
        List<EstudianteTO> listaTO = lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList());
        return listaTO;
        
    }

    private EstudianteTO convertir(Estudiante estudiante){
        EstudianteTO estuTo = new EstudianteTO();
            estuTo.setApellido(estudiante.getApellido());
            estuTo.setCedula(estudiante.getCedula());
            estuTo.setId(estudiante.getId());
            estuTo.setFechaNacimiento(estudiante.getFechaNacimiento());
            estuTo.setNombre(estudiante.getNombre());
            estuTo.setProvincia(estudiante.getProvincia());

        return estuTo;


    }
}





