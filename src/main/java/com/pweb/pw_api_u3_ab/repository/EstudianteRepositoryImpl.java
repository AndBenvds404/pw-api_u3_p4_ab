package com.pweb.pw_api_u3_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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

    @Override
    public void insertar(Estudiante estudiante) {
        this.entitymanager.persist(estudiante);
        
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        
       this.entitymanager.merge(estudiante);
    }

    @Override
    public void actualizarParcial(String cedula, String cedulaNueva) {
       
        Query mQuery = this.entitymanager.createQuery("UPDATE Estudiante e SET e.cedula =: datoCedula WHERE e.cedula =:datoCondicion");
        mQuery.setParameter("datoCedula", cedulaNueva);
        mQuery.setParameter("datoCondicion",cedula );
        mQuery.executeUpdate();

    }

    @Override
    public void borrar(Integer id) {
        
        this.entitymanager.remove(this.buscarPorId(id));
    }

    @Override
    public Estudiante buscarPorId(Integer id) {
        
       return this.entitymanager.find(Estudiante.class,id);
    }

    @Override
    public List<Estudiante> buscarTodos() {
     
        TypedQuery<Estudiante> a = this.entitymanager.createQuery("SELECT e FROM  Estudiante e", Estudiante.class);
        
        return a.getResultList();
    }

    


    
    
}
