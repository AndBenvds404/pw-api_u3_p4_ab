package com.pweb.pw_api_u3_ab.service;

import java.util.List;

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
    public Integer guardarDevolver(Estudiante estudiante) {
        // TODO Auto-generated method stub
        return this.estudianteRepository.insertarDevolver(estudiante);
    }
}





