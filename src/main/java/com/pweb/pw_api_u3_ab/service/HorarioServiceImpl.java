package com.pweb.pw_api_u3_ab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.pw_api_u3_ab.repository.IHorarioRepository;
import com.pweb.pw_api_u3_ab.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService {

    @Autowired
    private IHorarioRepository horarioRepository;

    @Override
    public Horario seleccionarPorCodigo(String codigo) {
       
        return this.horarioRepository.seleccionarPorCodigo(codigo);
    }

    @Override
    public void guardar(Horario estudiante) {
        
        this.horarioRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Horario horario) {
       
        this.horarioRepository.actualizar(horario);
    }

    @Override
    public void eliminar(Integer id) {
        
        this.horarioRepository.borrar(id);
    }

    

    @Override
    public void actualizarParcial(String duracion, String periodo) {
        
       this.horarioRepository.actualizarParcial(duracion, periodo);
    }

}





