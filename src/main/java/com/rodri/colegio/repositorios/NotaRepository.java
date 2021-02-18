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

	@Query(value = "select new com.rodri.colegio.dtos.Notas (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
			+ "FROM com.rodri.colegio.entities.NotasEntity n "
			+ "INNER JOIN com.rodri.colegio.entities.AlumnoEntity as a on n.alumnos.id = a.id "
			+ "INNER JOIN com.rodri.colegio.entities.AsignaturasEntity as asig on n.asignaturas.id = asig.id "
			+ "WHERE (a.id LIKE CONCAT('%',:id_Alumno,'%') or :id_Alumno is null) "
			+ "AND a.nombre LIKE CONCAT('%',:nombreAlumno, '%') "
			+ "AND (asig.id LIKE CONCAT('%',:id_Asignatura,'%') or :id_Asignatura is null) "
			+ "AND asig.nombre LIKE CONCAT('%',:asignatura, '%') "			
			+ "AND (n.nota LIKE CONCAT('%',:nota, '%') or :nota is null) "
			+ "AND n.fecha LIKE CONCAT('%',:fecha, '%')")
			List<Notas>buscaNotaporIdNombresNotaFecha(@Param("id_Alumno") Integer idAlumno, @Param("nombreAlumno") String nombre,
					@Param("id_Asignatura") Integer idAsignatura, @Param("asignatura") String asignatura, @Param("nota") Integer nota, @Param("fecha") String fecha);

}


