package com.pweb.pw_api_u3_ab.service;

import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

public interface IMateriaService {

   public Materia seleccionarPorCodigo(String codigo);

   public void guardar(Materia materia);

    
    
}
