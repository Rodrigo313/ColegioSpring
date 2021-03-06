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

import com.rodri.colegio.dao.ComboDAO;
import com.rodri.colegio.dao.NotaDAO;
import com.rodri.colegio.dtos.Alumno;
import com.rodri.colegio.dtos.Notas;
import com.rodri.colegio.entities.AlumnoEntity;
import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.entities.NotasEntity;
import com.rodri.colegio.repositorios.AlumnoRepository;
import com.rodri.colegio.repositorios.AsignaturaRepository;
import com.rodri.colegio.repositorios.NotaRepository;

/**
 * @author rodri
 *
 */
@Controller
public class NotaController {

	@Autowired
	private ComboDAO comboDAO;
	
	@Autowired
	private NotaDAO notaDAO;

	private static final Logger logger = LoggerFactory.getLogger(NotaController.class);
	
	//Insertar nota

	@GetMapping(value = "insertarnotas")
	public String formularioInsertarnotas(ModelMap model) {
		model.addAttribute("comboAlumnos", comboDAO.comboAlumnos());
		model.addAttribute("comboAsignaturas", comboDAO.comboAsignaturas());

		return "vistas/notas/insertarNotas";
	}
	
	@PostMapping(value = "insertarnotas")
	public String Insertarnota(@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Integer nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		model.addAttribute("resultado", notaDAO.insertarnota(alumno, asignatura, nota, fecha));


		return "vistas/notas/insertarNotas";
	}
	
	//Listar notas

	@GetMapping(value = "listadonotas")
	public String listadonotas(ModelMap model) {
		return "vistas/notas/listadoNotas";
	}
	
	@PostMapping(value = "listadonotas")
	public String listadonotas(@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "idA", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombre,				
			@RequestParam(value = "idAsig", required = false) Integer idAsignatura,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) Integer nota, 
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model) {

		model.addAttribute("lista", notaDAO.obtenerNotaporIdNombreAsignaturaNotaFecha(idAlumno, nombre, idAsignatura, asignatura, nota, fecha));

		return "vistas/notas/listadoNotas";
	}
	
	//Borrar notas

	@GetMapping(value = "formularioborrarnotas")
	public String borrarnota(ModelMap model) {
		return "vistas/notas/borrarNotas";
	}
	
	@PostMapping(value = "formularioborrarnotas")
	public String formularioBorrarnotas(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {

		model.addAttribute("lista", notaDAO.obtenerNotaporIdNombreAsignaturaNotaFecha(null, nombre, null, asignatura, null, fecha));

		return "vistas/notas/borrarNotas";
	}
	
	@PostMapping(value = "borrarnotas")
	public String borrarnota(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "tasa", required = false) Double tasa,
			@RequestParam(value = "curso", required = false) Integer curso, ModelMap model) {

		model.addAttribute("resultado", notaDAO.eliminarnota(id));

		return "vistas/notas/borrarNotas";
	}
	
	//Actualizar notas

	@GetMapping(value = "formulariomodificarnotas")
	public String actualizarnota(ModelMap model) {
		model.addAttribute("comboAlumnos", comboDAO.comboAlumnos());
		model.addAttribute("comboAsignaturas", comboDAO.comboAsignaturas());

		return "vistas/notas/modificarNotas";
	}

	
	@PostMapping(value = "formulariomodificarnotas")
	public String formularioModificarnotas(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {

		model.addAttribute("comboAlumnos", comboDAO.comboAlumnos());
		model.addAttribute("comboAsignaturas", comboDAO.comboAsignaturas());
		model.addAttribute("lista", notaDAO.obtenerNotaporIdNombreAsignaturaNotaFecha(null, nombre, null, asignatura, null, fecha));

		return "vistas/notas/modificarNotas";
	}

	@PostMapping(value = "modificarnotas")
	public String actualizarnota(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Integer nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		model.addAttribute("resultado", notaDAO.actualizarnota(id, alumno, asignatura, nota, fecha));

		return "vistas/notas/listadoNotas";
	}
}
