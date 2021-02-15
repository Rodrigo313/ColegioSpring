/**
 * 
 */
package com.rodri.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.rodri.colegio.entities.NotasEntity;

/**
 * @author rodri
 *
 */
public interface NotaRepository extends CrudRepository<NotasEntity, Integer>{

}
