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
import com.rodri.colegio.entities.MunicipiosEntity;
import com.rodri.colegio.repositorios.MunicipioRepository;

@Service
public class CombosDAOImpl implements ComboDAO{
	@Autowired
	private MunicipioRepository municipioRepository;
	@Override
	public List<ComboDTO> comboMunicipios() {
		Iterable<MunicipiosEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		List<ComboDTO> listaMunicipios = mapeoEntidadMunicipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<ComboDTO> mapeoEntidadMunicipioComboDTO(Iterable<MunicipiosEntity> listaEntidadesMunicipios){
		List<ComboDTO> listaMunicipios = new ArrayList<ComboDTO>();
		for(MunicipiosEntity m: listaEntidadesMunicipios) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		return listaMunicipios;
	}

}
