/**
 * 
 */
package com.rodri.colegio.dao;

import java.util.List;

import com.rodri.colegio.dtos.Asignaturas;

/**
 * @author 201909
 *
 */
public interface AsignaturaDAO {
	List<Asignaturas> obtenerAsignaturaporIdyNombre(Integer id, String nombre);
	Integer insertarasignatura(Integer id, String nombre, Integer curso, Double tasa);
	Integer actualizarasignatura(Integer id, String nombre, Integer curso, Double tasa);
	Integer eliminarasignatura(Integer id);
}
