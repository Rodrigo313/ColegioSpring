package com.rodri.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rodri.colegio.dtos.Alumno;
import com.rodri.colegio.entities.AlumnoEntity;

public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Integer>{
	@Query(value = "select new com.rodri.colegio.dtos.Alumno (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa) "
			+ "FROM com.rodri.colegio.entities.AlumnoEntity a, com.rodri.colegio.entities.MunicipiosEntity m "
			+ "WHERE a.idMunicipio = m.idMunicipio "
			+ "AND (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT ('%', :nombre, '%') ")
	List<Alumno>buscaAlumnosporIDyNombre(@Param("id") Integer id, @Param("nombre")String nombre);
}
