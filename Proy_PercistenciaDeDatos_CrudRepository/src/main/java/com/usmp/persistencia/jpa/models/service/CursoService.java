package com.usmp.persistencia.jpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.jpa.models.dao.ICursoDAO;
import com.usmp.persistencia.jpa.models.entity.CursoEntity;

@Service //indicarle que es servicio
public class CursoService implements ICursoService{
	@Autowired
	private ICursoDAO cursoDao;//obj instancie a la interface dao

	@Override
	@Transactional(readOnly = true)
	public List<CursoEntity> findAll() {
		return (List<CursoEntity>) cursoDao.findAll();
	}

	@Override
	@Transactional
	public void save(CursoEntity curso) {
		System.out.println(curso.toString());
		cursoDao.save(curso);
	}

	@Override
	@Transactional(readOnly = true)
	public CursoEntity findOne(Long id) {
		return cursoDao.findById(id).orElse(null);
		//si lo encuentra te devuelve el todo el obj con datos
		//sino te devuelve null
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cursoDao.deleteById(id);
	}
	
	
	
	
	
}
