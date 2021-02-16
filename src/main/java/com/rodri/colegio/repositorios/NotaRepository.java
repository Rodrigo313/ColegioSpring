/**
 * 
 */
package com.rodri.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rodri.colegio.dtos.Notas;
import com.rodri.colegio.entities.NotasEntity;

/**
 * @author rodri
 *
 */
public interface NotaRepository extends CrudRepository<NotasEntity, Integer>{

	@Query(value = "select new com.rodri.colegio.dtos.Notas (a.id,m.id, c.id, a.nota, a.fecha, m.nombre, c.nombre) "
			+ "FROM com.rodri.colegio.entities.NotasEntity a, com.rodri.colegio.entities.AlumnoEntity m, com.rodri.colegio.entities.AsignaturasEntity c "
			+ "WHERE a.alumnos.id = m.id AND a.asignaturas.id=c.id "
			+ "AND (m.id LIKE CONCAT('%', :id,'%') or :id is null) "
			+ "AND (m.nombre LIKE CONCAT ('%', :nombreAlumno, '%') or :nombreAlumno is null) "
			+ "AND (c.nombre LIKE CONCAT ('%', :nombreAsignatura, '%') or :nombreAsignatura is null) "
			+ "AND (a.fecha LIKE CONCAT ('%', :fecha, '%') or :fecha is null) "
			+ "AND (a.nota LIKE CONCAT ('%', :nota, '%') or :nota is null) ")
	List<Notas>buscarPorAlumnoAsignaturaNotaFecha(@Param("id") Integer idAlumno, @Param("nombreAlumno")String nombreAlumno, @Param("nombreAsignatura") String asignatura, @Param("nota")Integer nota, @Param("fecha") String fecha);
}

