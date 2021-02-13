/**
 * 
 */
package com.rodri.colegio.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodri.colegio.dao.ComboDAO;
import com.rodri.colegio.dtos.Asignaturas;
import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.repositorios.AsignaturaRepository;

/**
 * @author 201909
 *
 */
public class AsignaturaController {
	@Autowired
	private ComboDAO combo;

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);
	
	
	
	@GetMapping (value = "listadoasignaturas")
	private String listadoAsignaturas (ModelMap model) {
		return "vistas/asignaturas/listaAsignaturas";
	}
	
	@PostMapping(value = "listarasignaturas")
	public String listadoAsignaturas(@RequestParam(value = "id", required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		
		List<Asignaturas> listaAsignaturas = asignaturaRepository.buscaAsignaturaporIdNombre(id, nombre);
		model.addAttribute("lista", listaAsignaturas);
		return "vistas/asignaturas/listaAsignaturas";
	}
}
