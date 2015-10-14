/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 24-08-2015
 * 
 */
package cl.cesarg.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import cl.cesarg.entities.Usuario;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion	Objeto en base de datos del usuario 
 * 				de la aplicación 
 *
 */
@Component
public class DaoUsuario {

	@SuppressWarnings("unchecked")
	public List<Usuario> getAll () {
		// Conexion persistente a la base de datos
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// Inicializo la lista vacia
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Creo la consulta para todos los elementos
		Query q = pm.newQuery( Usuario.class );
		try {
			// proceso la data obtenida desde la base de datos
			usuarios = ( List<Usuario> ) q.execute(); 
		} finally {
			// Cierro la conexion
			pm.close();
		}
		// Retorno de la data obtenida
		return usuarios;
	}

	
	public Usuario getById ( String id ) {
		// Instancio una conexion persistente
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// inicializo el objeto como nulo
		Usuario usuario = null;
		// Genero la clave de busqueda
		Key key = KeyFactory.createKey(Usuario.class.getSimpleName(), id);
		try {
			// Obtengo el elemento desde la base de datos
			usuario = pm.getObjectById(Usuario.class, key);
			
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		} finally {
			// Cierro la conexion
			pm.close();
		}
		// retorno el objeto obtenido desde BD
		return usuario;
	}
	
	
	@SuppressWarnings("unchecked")
	public Usuario findByEmail ( String email ) {
		PersistenceManager pm 	= PMF.get().getPersistenceManager();
		List<Usuario> usuarios 	= new ArrayList<Usuario>();
		Usuario usuario 		= null;
		try {
			Query q = pm.newQuery( Usuario.class );
			q.setFilter("id == idObjeto");
			q.declareParameters("String idObjeto");
			usuarios = (List<Usuario>) q.execute( email );
			if ( usuarios.size() > 0 ) {
				usuario = usuarios.get(0);
			}
		} finally {
			pm.close();
		}
		return usuario;
	}
	
	
	public Usuario insertUpdate ( Usuario data ) {
		// Incializo el objeto a retornar
		Usuario usuario = null;
		// Creo una instancia de persistencia a la base de datos
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			// Acciona el guardar o actualizar
			usuario = pm.makePersistent(data);
		} finally {
			// Cierra la conexiÃ³n
			pm.close();
		}
		// Retorna el objeto
		return usuario;
	}
	
	
	public void delete ( Long id ) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery( Usuario.class );
			q.setFilter("id == idObjeto");
			q.declareParameters("Long idObjeto");
			q.deletePersistentAll( id );
		} finally {
			pm.close();
		}
	}
	
	
}
