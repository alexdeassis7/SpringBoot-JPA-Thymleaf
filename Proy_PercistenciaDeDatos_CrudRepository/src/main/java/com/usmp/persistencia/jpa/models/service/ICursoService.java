package com.usmp.persistencia.jpa.models.service;

import java.util.List;

import com.usmp.persistencia.jpa.models.entity.CursoEntity;

public interface ICursoService {
	public List<CursoEntity> findAll();
	public void save(CursoEntity curso); 
	//metodo que sirve pa registrar un nuevo curso y pa actualizar o modificar los datos
	public CursoEntity findOne(Long id); //para hacer una busqueda
	public void delete (Long id);
}
