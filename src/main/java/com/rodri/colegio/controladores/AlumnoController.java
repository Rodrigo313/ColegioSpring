/**
 * 
 */
package com.rodri.colegio.controladores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodri.colegio.dao.ComboDAO;
import com.rodri.colegio.dtos.ComboDTO;
import com.rodri.colegio.entities.AlumnoEntity;
import com.rodri.colegio.entities.MunicipiosEntity;
import com.rodri.colegio.repositorios.AlumnoRepository;
import com.rodri.colegio.repositorios.MunicipioRepository;



/**
 * @author 201909
 * 
 */
@Controller
public class AlumnoController {
	@Autowired
	private ComboDAO combo;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@GetMapping(value = "insertarAlumnos")
	public String formularioInsertarAlumnos(ModelMap model) {
		
		model.addAttribute("comboMunicipio", combo.comboMunicipios());
		return "vistas/alumnos/insertarAlumnos";
	}
	
	
	
	@PostMapping(value = "insertarAlumnos")
	public String InsertarAlumno(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa") Integer familiaNumerosa,
			ModelMap model) {
		
		familiaNumerosa = (familiaNumerosa == null) ? 0 : 1;
		
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, idMunicipio, familiaNumerosa);
		
		alumnoRepository.save(alumno);
		
		model.addAttribute("comboMunicipio", combo.comboMunicipios());
		return "vistas/alumnos/insertarAlumnos";
	}
	
}
