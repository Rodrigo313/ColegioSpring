package com.rodri.colegio.dao;

import java.util.List;

import com.rodri.colegio.dtos.ComboDTO;

public interface ComboDAO {

	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
 }
