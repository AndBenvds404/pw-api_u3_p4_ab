package com.pweb.pw_api_u3_ab.repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

public interface IMateriaRepository  {
    
    public Materia seleccionarPorCodigo(String codigo);

    public void insertar(Materia materia);
    
}
