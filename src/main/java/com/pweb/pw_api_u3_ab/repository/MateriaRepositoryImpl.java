package com.pweb.pw_api_u3_ab.repository;

import org.springframework.stereotype.Repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public Materia seleccionarPorCodigo(String codigo) {
        
   

        TypedQuery<Materia> myQuery = this.entitymanager
        .createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo", Materia.class);
            myQuery.setParameter("datoCodigo", codigo);
            return myQuery.getSingleResult();
    }

    @Override
    public void insertar(Materia materia) {
        this.entitymanager.persist(materia);
        
    }

    


    
    
}
