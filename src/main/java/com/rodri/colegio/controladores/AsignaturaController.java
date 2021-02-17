/**
 * 
 */
package com.rodri.colegio.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodri.colegio.dao.AsignaturaDAO;
import com.rodri.colegio.dao.ComboDAO;
import com.rodri.colegio.dao.imp.AsignaturaDAOImpl;
import com.rodri.colegio.dtos.Asignaturas;
import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.repositorios.AsignaturaRepository;

/**
 * @author 201909
 *
 */
@Controller
public class AsignaturaController {
	
	@Autowired
	private ComboDAO combo;

	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);
	
	
	//Listar asignaturas
	@GetMapping (value = "listarasignaturas")
	private String listadoAsignaturas (ModelMap model) {
		return "vistas/asignaturas/listaAsignaturas";
	}
	
	@PostMapping(value = "listarasignaturas")
	public String listadoAsignaturas(@RequestParam(value = "id", required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		model.addAttribute("listaAsignatura", asignaturaDAO.obtenerAsignaturaporIdyNombre(id, nombre));
		return "vistas/asignaturas/listaAsignaturas";
	}
	
	//Insertar asignaturas
	@GetMapping(value = "insertarasignaturas")
	private String insertarAsignaturas(ModelMap model) {
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	@PostMapping(value = "insertarasignaturas")
	public String insertarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam("curso") Integer curso,
			@RequestParam("tasa") Double tasa, ModelMap model) {
		model.addAttribute("resultado", asignaturaDAO.insertarasignatura(id, nombre, curso, tasa));
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	//Borrar asignaturas
	@GetMapping(value = "formularioborrarasignaturas")
	private String borrarAsignatura(ModelMap model) {
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "formularioborrarasignaturas")
	public String formularioBorrarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {
		model.addAttribute("lista", asignaturaDAO.obtenerAsignaturaporIdyNombre(id, nombre));
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "borrarasignaturas")
	public String borrarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		model.addAttribute("resultado", asignaturaDAO.eliminarasignatura(id));
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	//Actualizar asignaturas
	@GetMapping(value = "formulariomodificarasignaturas")
	private String modificarAsignatura(ModelMap model) {
		return "vistas/asignaturas/modificarAsignaturas";
	}
	
	@PostMapping(value = "formulariomodificarasignaturas")
	public String formularioModificarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {
		model.addAttribute("lista", asignaturaDAO.obtenerAsignaturaporIdyNombre(id, nombre));
		return "vistas/asignaturas/modificarAsignaturas";
	}
	
	@PostMapping(value = "modificarasignaturas")
	public String modificarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam("curso") Integer curso,
			@RequestParam("tasa") Double tasa, ModelMap model) {
		model.addAttribute("resultado", asignaturaDAO.actualizarasignatura(id, nombre, curso, tasa));
		return "vistas/asignaturas/modificarAsignaturas";
	}
	
}
