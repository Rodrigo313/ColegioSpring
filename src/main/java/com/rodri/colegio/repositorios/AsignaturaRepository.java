package com.rodri.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rodri.colegio.dtos.Asignaturas;
import com.rodri.colegio.entities.AsignaturasEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturasEntity, Integer>{
	@Query(value = "select new com.rodri.colegio.dtos.Asignaturas (a.id, a.nombre, a.curso, a.tasa) "
			+ "FROM com.rodri.colegio.entities.AsignaturasEntity a "
			+ "WHERE (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT('%',:nombre,'%')")
			List<Asignaturas>buscaAsignaturaporIdNombre(@Param("id") Integer id, @Param("nombre") String nombre);
	
	@Query(value = "select new com.rodri.colegio.dtos.Asignaturas (a.id, a.nombre, a.curso, a.tasa) "
			+ "FROM com.rodri.colegio.entities.AsignaturasEntity a "
			+ "WHERE (a.id LIKE CONCAT('%',:id,'%') or :id is null) "			
			+ "AND a.nombre LIKE CONCAT('%',:nombre,'%') "
			+ "AND (a.curso LIKE CONCAT('%',:curso,'%') or :curso is null) "
			+ "AND (a.tasa LIKE CONCAT('%',:tasa,'%') or :tasa is null)")
			List<Asignaturas>buscaAsignaturaporIdNombreCursoTasa(@Param("id") Integer id, @Param("nombre") String nombre,
					@Param("curso") Integer curso, @Param("tasa") Double tasa);
}
