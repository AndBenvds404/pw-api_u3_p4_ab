package com.pweb.pw_api_u3_ab.service;


import com.pweb.pw_api_u3_ab.repository.modelo.Horario;

public interface IHorarioService {

   public Horario seleccionarPorCodigo(String codigo);

   public void guardar(Horario horario);

    public void actualizar (Horario horario);
    
    public void actualizarParcial(String duracion , String periodo);

    public void eliminar (Integer id);



}