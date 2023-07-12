package com.pweb.pw_api_u3_ab.repository;

import org.springframework.stereotype.Repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;

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
        
   

        TypedQuery<Estudiante> myQuery = this.entitymanager
        .createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula", Estudiante.class);
            myQuery.setParameter("datoCedula", cedula);
            return myQuery.getSingleResult();
    }


    
    
}
