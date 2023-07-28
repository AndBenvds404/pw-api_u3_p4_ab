package com.pweb.pw_api_u3_ab.service;

import java.util.List;

import com.pweb.pw_api_u3_ab.service.to.MateriaTo;

public interface IMateriaService {
    
    public List<MateriaTo> buscarPorCedulaEstudainte(String cedula);
    public List<MateriaTo> buscarMateriaPorId(Integer id);
}
