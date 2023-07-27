package com.pweb.pw_api_u3_ab.repository;

import java.util.List;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    
    public Estudiante seleccionarPorcedula(String cedula);

    public void insertar(Estudiante estudiante);

    public Estudiante insertarDevolver(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public void actualizarParcial(String cedula, String nuevaCedula);

    public void borrar (Integer id);

    public Estudiante buscarPorId(Integer id);

    public List<Estudiante> buscarTodos();

    public List<Estudiante> buscarTodosProvincia(String provincia);
    
}
