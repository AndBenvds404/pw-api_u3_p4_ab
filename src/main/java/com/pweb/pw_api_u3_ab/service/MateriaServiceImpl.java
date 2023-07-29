package com.pweb.pw_api_u3_ab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.pw_api_u3_ab.repository.MateriaRepositoryImpl;
import com.pweb.pw_api_u3_ab.repository.modelo.Materia;
import com.pweb.pw_api_u3_ab.service.to.MateriaTo;

@Service
public class MateriaServiceImpl implements IMateriaService{


    @Autowired
    private MateriaRepositoryImpl materiaRepositoryImpl;
    
    
    @Override
    public List<MateriaTo> buscarPorCedulaEstudainte(String cedula) {

        List<Materia> lista = this.materiaRepositoryImpl.buscarPorCedulaEstudiante(cedula);
        List<MateriaTo> listaMateria = lista.stream().map(mater->this.convertir(mater)).collect(Collectors.toList());
        return listaMateria;

    }



    

    private MateriaTo convertir(Materia materia){

        MateriaTo mateTo = new MateriaTo();
        mateTo.setId(materia.getId());
        mateTo.setNombre(materia.getNombre());
        mateTo.setNumeroCodigo(materia.getNumeroCodigo());
    
        return mateTo;
    }





	@Override
	public MateriaTo buscarMateriaPorId(Integer id) {
		
		return this.convertir(this.materiaRepositoryImpl.buscarPorMateriasId(id));
	}





	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepositoryImpl.insertar(materia);
	}





	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepositoryImpl.buscarPorMateriasId(id);
	}




 



    
}
