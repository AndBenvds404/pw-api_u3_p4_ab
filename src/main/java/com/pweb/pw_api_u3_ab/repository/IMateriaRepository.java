package com.pweb.pw_api_u3_ab.repository;

import java.util.List;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;
import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

public interface IMateriaRepository {
    public List<Materia> buscarPorCedulaEstudiante(String cedula);
    public Materia buscarPorMateriasId(Materia materia);
    public List<Materia> buscarTodosMaterias();
}
