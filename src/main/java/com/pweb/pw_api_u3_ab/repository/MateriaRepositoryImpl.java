package com.pweb.pw_api_u3_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;
import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Materia> buscarPorCedulaEstudiante(String cedula){

        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m Where m.estudiante.cedula =:datoCedula", Materia.class);
            myQuery.setParameter("datoCedula", cedula);
        return myQuery.getResultList();
    }


    @Override
    public Materia buscarPorMateriasId(Materia materia) {

           return this.entityManager.find(Materia.class, materia.getId());
    }


    @Override
    public List<Materia> buscarTodosMaterias() {
        var mQuery = this.entityManager.createQuery("SELECT e FROM Materia e ",Materia.class);
        return mQuery.getResultList();
    }
    




    
    
}
