package com.pweb.pw_api_u3_ab.service;

import java.util.List;

import com.pweb.pw_api_u3_ab.repository.modelo.Materia;
import com.pweb.pw_api_u3_ab.service.to.MateriaTo;

public interface IMateriaService {
    

	public List<MateriaTo> buscarPorCedulaEstudainte(String cedula);
    public MateriaTo buscarMateriaPorId(Integer id);
	public void guardar(Materia materia);
	public Materia buscarPorId(Integer id);
}
