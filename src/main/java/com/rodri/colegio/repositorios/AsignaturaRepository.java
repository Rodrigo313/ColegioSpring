package com.rodri.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rodri.colegio.dtos.Asignaturas;
import com.rodri.colegio.entities.AsignaturasEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturasEntity, Integer>{
	@Query(value = "select new com.rodri.colegio.dtos.AsignaturaDTO2 (a.id, a.nombre, a.curso, a.tasa) "
			+ "FROM com.rodri.colegio.entities.AsignaturasEntity a "
			+ "WHERE (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombreAsignatura LIKE CONCAT('%',:nombreAsignatura,'%')")
			List<Asignaturas>buscaAsignaturaporIdNombre(@Param("id") Integer id, @Param("nombre") String nombre);
}
