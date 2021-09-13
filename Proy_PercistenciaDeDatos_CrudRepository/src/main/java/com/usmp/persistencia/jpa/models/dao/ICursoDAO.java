package com.usmp.persistencia.jpa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.usmp.persistencia.jpa.models.entity.CursoEntity;

public interface ICursoDAO  extends CrudRepository<CursoEntity, Long> {
	//CrudRepository<T, ID>  t= nombre de la entidad (Clase)  id=tipo de dato del id
}
