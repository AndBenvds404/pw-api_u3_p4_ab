package com.pweb.pw_api_u3_ab.repository;

import org.springframework.stereotype.Repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public Horario seleccionarPorCodigo(String codigo) {
   
        TypedQuery<Horario> myQuery = this.entitymanager
        .createQuery("SELECT h FROM Horario h WHERE h.codigo = :datoCodigo", Horario.class);
            myQuery.setParameter("datoCodigo", codigo);
            return myQuery.getSingleResult();
    }

    @Override
    public void insertar(Horario horario) {
        this.entitymanager.persist(horario);
        
    }

    @Override
    public void actualizar(Horario horario) {
        
       this.entitymanager.merge(horario);
    }

    @Override
    public void actualizarParcial(String duracion, String periodo) {
       
        Query mQuery = this.entitymanager.createQuery("UPDATE Horario h SET h.duracion =: datoDuracion WHERE h.periodo =:datoPeriodo");
        mQuery.setParameter("datoDuracion", duracion);
        mQuery.setParameter("datoPeriodo",periodo );
        mQuery.executeUpdate();

    }

    @Override
    public void borrar(Integer id) {
        
        this.entitymanager.remove(this.buscarPorId(id));
    }

    @Override
    public Horario buscarPorId(Integer id) {
        
       return this.entitymanager.find(Horario.class,id);
    }

    
    
}
