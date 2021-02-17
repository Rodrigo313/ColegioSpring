/**
 * 
 */
package com.rodri.colegio.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodri.colegio.dao.AsignaturaDAO;
import com.rodri.colegio.dtos.Asignaturas;
import com.rodri.colegio.entities.AsignaturasEntity;
import com.rodri.colegio.repositorios.AsignaturaRepository;

/**
 * @author 201909
 *
 */
@Service
public class AsignaturaDAOImpl implements AsignaturaDAO{
	

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	//Listar asignaturas
	
		@Override
		public List<Asignaturas> obtenerAsignaturaporIdyNombre(Integer id, String nombre) {
			
			return asignaturaRepository.buscaAsignaturaporIdNombre(id, nombre);
		}
		
		
		//Insertar asignaturas
		
		@Override
		public Integer insertarasignatura(Integer id, String nombre, Integer curso, Double tasa) {
			
			AsignaturasEntity asignatura = new AsignaturasEntity(id, nombre, curso, tasa);
			
			asignaturaRepository.save(asignatura);		
			
			return 1;
		}
		
		
		
		//Actualizar asignaturas
		
		@Override
		public Integer actualizarasignatura(Integer id, String nombre, Integer curso, Double tasa) {
			
			AsignaturasEntity asignatura = new AsignaturasEntity(id, nombre, curso, tasa);
			
			asignaturaRepository.save(asignatura);
			
			
			return 1;
		}
		
		
		
		//Borrar asignaturas
		
		@Override
		public Integer eliminarasignatura(Integer id) {
			
			asignaturaRepository.deleteById(id);
			return 1;
		}
}
