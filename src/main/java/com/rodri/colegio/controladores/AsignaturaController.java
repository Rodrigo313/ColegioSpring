/**
 * 
 */
package com.rodri.colegio.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.repositorios.AsignaturaRepository;

/**
 * @author 201909
 *
 */
public class AsignaturaController {
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);
	
	@GetMapping(value = "insertarasignaturas")
	public String insertarAsignatura(ModelMap model) {
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	@PostMapping(value = "insertarasignaturas")
	public String InsertarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso") Integer curso,
			@RequestParam(value = "tasa") Double tasa, ModelMap model) {
		
		
		AsignaturasEntity asignatura = new AsignaturasEntity(id, nombre, curso, tasa);
		
		asignaturaRepository.save(asignatura);
		
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
}
