package com.pweb.pw_api_u3_ab.service;


import java.util.List;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;
import com.pweb.pw_api_u3_ab.repository.modelo.Materia;
import com.pweb.pw_api_u3_ab.service.to.EstudianteTO;

public interface IEstudianteService {

   public Estudiante seleccionarPorCedula(String cedula);

   public void guardar(Estudiante estudiante);

   public Estudiante guardarDevolver(Estudiante estudiante);

    public void actualizar (Estudiante estudiante);
    
    public void actualizarParcial(String cedula, String nuevaCedula);

    public void eliminar (Integer id);

    public List<Estudiante> buscarTodos();
    
    public List<Estudiante> buscarTodosProvincia (String provincia);

    public List<EstudianteTO> buscarTodosHateoas();

    public Materia seleccionarMateriasPorId(Integer id);

}