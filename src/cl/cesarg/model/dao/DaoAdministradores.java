/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 12-10-2015
 * 
 */
package cl.cesarg.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

import cl.cesarg.entities.Administrador;


/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class DaoAdministradores {

	
	/**
	 * Lista completa de administradores
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Administrador> getAll () {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Administrador> _administradores = new ArrayList<Administrador>();
		
		Query q = pm.newQuery( Administrador.class );
		try {
			_administradores = (List<Administrador>) q.execute();
		} finally {
			pm.close();
		}
		return _administradores;
		
	}
	
	
	
	public Administrador getById ( Long id ) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Administrador administrador = null;
		Key key = KeyFactory.createKey( Administrador.class.getSimpleName(), id );
		try {
			administrador = pm.getObjectById( Administrador.class, key );
		} finally {
			pm.close();
		}
		return administrador;
	}
	
	
	public Administrador insertUpdate ( Administrador data ) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Administrador administrador = new Administrador();
		try {
			administrador = pm.makePersistent( data );
		} finally {
			pm.close();
		}
		return administrador;
	}
	
	
	public void delete ( Long id ) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery( Administrador.class );
			q.setFilter("id == idObjeto");
			q.declareParameters("Long idObjeto");
			q.deletePersistentAll( id );
		} finally {
			pm.close();
		}
	}
	
	
}
