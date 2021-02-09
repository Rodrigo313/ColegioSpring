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

import com.rodri.colegio.dtos.ComboDTO;
import com.rodri.colegio.entities.MunicipiosEntity;
import com.rodri.colegio.repositorios.MunicipioRepository;



/**
 * @author 201909
 * 
 */
@Controller
public class AlumnoController {
	@Autowired
	private MunicipioRepository municipioRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@GetMapping
	public String formularioInsertarAlumnos(ModelMap model) {
		Iterable<MunicipiosEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		List<ComboDTO> listaMunicipios = mapeoEntidadMunicipioComboDTO(listaEntidadesMunicipios);
		model.addAttribute("comboMunicipios", listaMunicipios);
		return "vistas/alumnos/insertarAlumnos";
	}
}