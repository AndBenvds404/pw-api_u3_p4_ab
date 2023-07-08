package com.pweb.pw_api_u3_ab.repository;

import org.springframework.stereotype.Repository;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public Estudiante seleccionarPorcedula(String cedula) {
        // TODO Auto-generated method stub
        TypedQuery<Estudiante> myQuery = this.entitymanager.createQuery("SELECT r FROM  Estudiante r WHERE r.cedula =:datoCedula",Estudiante.class);
        myQuery.setParameter("datoCedula", cedula);
        return myQuery.getSingleResult();
    }


    
    
}
