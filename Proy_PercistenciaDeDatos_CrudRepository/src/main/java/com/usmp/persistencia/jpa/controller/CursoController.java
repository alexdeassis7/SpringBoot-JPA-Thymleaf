package com.usmp.persistencia.jpa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.usmp.persistencia.jpa.models.entity.CursoEntity;
import com.usmp.persistencia.jpa.models.service.ICursoService;

@Controller
@SessionAttributes("curso")
public class CursoController {
	//vista con el controller, controller con el servicio
	@Autowired
	private ICursoService cursoService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) { //devulve todos lo cursos registrados en la tabla
	model.addAttribute("cursos", cursoService.findAll()); //findAll que esta en el servicio 
	//llama a lo q se encuentra en el ICursoServico y dsp hace que se ejecute lo que esta 
	//en el CursoService y a partir de eso hace que se ejecute el del DAO (crud repository), ese crud accede a la base de datos
	return "listar";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		CursoEntity curso = new CursoEntity();
		model.put("curso", curso);
		model.put("titulo", "Mantenimineto Tabla Curso");
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Validated CursoEntity curso, BindingResult result, Model model, SessionStatus status) {
	//registrar o guardar
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Mantenimiento Tabla Curso");
			return "form";
		}
		curso.setId(1);
		System.out.println(curso);
		cursoService.save(curso);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id>0) {
			cursoService.delete(id);
		}
		
		return "redirect:/listar";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable (value = "id") Long id, Map<String, Object> model) {
		CursoEntity curso = null;
		
		if(id > 0) {
			curso = cursoService.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("curso", curso);
		model.put("titulo", "Editar Curso");
		return "form";
	}
	

}
