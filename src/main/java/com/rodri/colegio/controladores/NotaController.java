/**
 * 
 */
package com.rodri.colegio.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.rodri.colegio.dao.ComboDAO;
import com.rodri.colegio.repositorios.NotaRepository;

/**
 * @author rodri
 *
 */
public class NotaController {
	@Autowired
	private ComboDAO combo;
	@Autowired
	private NotaRepository notaRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(NotaController.class);
	
	//Listar notas
	@GetMapping(value = "listadonotas")
	private String listadoNotas(ModelMap model) {
		return "vistas/notas/listadoNotas";
	}
}
