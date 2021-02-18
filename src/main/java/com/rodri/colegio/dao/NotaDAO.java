/**
 * 
 */
package com.rodri.colegio.dao;

import java.util.List;

import com.rodri.colegio.dtos.Notas;

/**
 * @author 201909
 *
 */
public interface NotaDAO {
	List<Notas> obtenerNotaporIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre, Integer idAsignatura, String asignatura, Integer nota, String fecha);
	Integer insertarnota(Integer alumno, Integer asignatura, Integer nota, String fecha);
	Integer actualizarnota(Integer id, Integer alumno, Integer asignatura, Integer nota, String fecha);
	Integer eliminarnota(Integer id);
}
