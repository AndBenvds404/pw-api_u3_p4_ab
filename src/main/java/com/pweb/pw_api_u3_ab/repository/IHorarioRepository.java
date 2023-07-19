package com.pweb.pw_api_u3_ab.repository;



import com.pweb.pw_api_u3_ab.repository.modelo.Horario;

public interface IHorarioRepository {
    
    public Horario seleccionarPorCodigo(String codigo);

    public void insertar(Horario horario);

    public void actualizar(Horario Horario);

    public void actualizarParcial(String duracion, String periodo);

    public void borrar (Integer id);

    public Horario buscarPorId(Integer id);


    
}
