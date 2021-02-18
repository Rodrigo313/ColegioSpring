package com.rodri.colegio.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodri.colegio.dao.ComboDAO;
import com.rodri.colegio.dtos.ComboDTO;
import com.rodri.colegio.entities.AlumnoEntity;
import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.entities.MunicipiosEntity;
import com.rodri.colegio.repositorios.AlumnoRepository;
import com.rodri.colegio.repositorios.AsignaturaRepository;
import com.rodri.colegio.repositorios.MunicipioRepository;

@Service
public class CombosDAOImpl implements ComboDAO{
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	@Override
	public List<ComboDTO> comboMunicipios() {
		Iterable<MunicipiosEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		List<ComboDTO> listaMunicipios = mapeoEntidadMunicipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumnos = alumnoRepository.findAll();
		List<ComboDTO> listaAlumnos = mapeoEntidadAlumnoComboDTO(listaEntidadesAlumnos);
		return listaAlumnos;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		Iterable<AsignaturasEntity> listaEntidadesAsignaturas = asignaturaRepository.findAll();
		List<ComboDTO> listaAsignaturas = mapeoEntidadAsignaturaComboDTO(listaEntidadesAsignaturas);
		return listaAsignaturas;
	}
	
	private List<ComboDTO> mapeoEntidadMunicipioComboDTO(Iterable<MunicipiosEntity> listaEntidadesMunicipios){
		List<ComboDTO> listaMunicipios = new ArrayList<ComboDTO>();
		for(MunicipiosEntity m: listaEntidadesMunicipios) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		return listaMunicipios;
	}
	
	private List<ComboDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity> listaEntidadesAlumnos){
		List<ComboDTO> listaAlumnos = new ArrayList<ComboDTO>();
		for(AlumnoEntity m: listaEntidadesAlumnos) {
			listaAlumnos.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		return listaAlumnos;
	}
	
	private List<ComboDTO> mapeoEntidadAsignaturaComboDTO(Iterable<AsignaturasEntity> listaEntidadesAsignaturas){
		List<ComboDTO> listaAsignaturas = new ArrayList<ComboDTO>();
		for(AsignaturasEntity m: listaEntidadesAsignaturas) {
			listaAsignaturas.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		return listaAsignaturas;
	}

}
