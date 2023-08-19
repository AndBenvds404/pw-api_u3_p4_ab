package com.pweb.pw_api_u3_ab.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pweb.pw_api_u3_ab.repository.modelo.Materia;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Materia> buscarPorCedulaEstudiante(String cedula) {

		TypedQuery<Materia> myQuery = this.entityManager
				.createQuery("SELECT m FROM Materia m Where m.estudiante.cedula =:datoCedula", Materia.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getResultList();
	}

	@Override
	public Materia buscarPorMateriasId(Integer id) {

		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.id = :datoId",
				Materia.class);
		myQuery.setParameter("datoId", id);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {

		this.entityManager.persist(materia);

	}

}
