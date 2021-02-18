/**
 * 
 */
package com.rodri.colegio.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodri.colegio.dao.NotaDAO;
import com.rodri.colegio.dtos.Notas;
import com.rodri.colegio.entities.AlumnoEntity;
import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.entities.NotasEntity;
import com.rodri.colegio.repositorios.AlumnoRepository;
import com.rodri.colegio.repositorios.AsignaturaRepository;
import com.rodri.colegio.repositorios.NotaRepository;

/**
 * @author 201909
 *
 */
@Service
public class NotaDAOImpl implements NotaDAO{
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	//Listar nota
	@Override
	public List<Notas> obtenerNotaporIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre,
			Integer idAsignatura, String asignatura, Integer nota, String fecha) {
		
		return notaRepository.buscaNotaporIdNombresNotaFecha(idAlumno, nombre, idAsignatura, asignatura, nota, fecha);
	}

	
	
	//Insertar nota
	@Override
	public Integer insertarnota(Integer alumno, Integer asignatura, Integer nota, String fecha) {
		
		AlumnoEntity alumnoEntity = alumnoRepository.findById(alumno).get();
		AsignaturasEntity asignaturasEntity = asignaturaRepository.findById(asignatura).get();
		
		NotasEntity notas = new NotasEntity(alumnoEntity, asignaturasEntity, nota, fecha);

		notaRepository.save(notas);
		
		return 1;
	}

	
	//Modificar nota
	@Override
	public Integer actualizarnota(Integer id, Integer alumno, Integer asignatura, Integer nota, String fecha) {
		
		AlumnoEntity alumnoEntity = alumnoRepository.findById(alumno).get();
		AsignaturasEntity asignaturasEntity = asignaturaRepository.findById(asignatura).get();
		
		NotasEntity notas = new NotasEntity(id, alumnoEntity, asignaturasEntity, nota, fecha);

		notaRepository.save(notas);
		
		
		return 1;
	}

	
	//Borrar nota
	@Override
	public Integer eliminarnota(Integer id) {
		
		notaRepository.deleteById(id);
		
		return 1;
	}
}
