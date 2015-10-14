/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 12-10-2015
 * 
 */
package cl.cesarg.model.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Administrador;
import cl.cesarg.model.dao.DaoAdministradores;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class FacadeAdministradores {

	@Autowired
	DaoAdministradores _daoAdministradores;
	
	/**
	 * Lista completa de administradores
	 * @return
	 */
	public List<Administrador> getAll () {
		return this._daoAdministradores.getAll();
	}
	
	public Administrador insertUpdate ( Administrador administrador ) {
		return this._daoAdministradores.insertUpdate( administrador );
	}
	
	public Administrador getById ( Long id ) {
		return this._daoAdministradores.getById(id);
	}
	
	public void delete ( Long id ) {
		this._daoAdministradores.delete( id );
	}
	
}
