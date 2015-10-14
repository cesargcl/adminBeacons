/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 23-08-2015
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

import cl.cesarg.entities.Beacon;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class DaoBeacon {

			
	/**
	 * Obtiene todos los beacons desde BD		
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Beacon> getAll () {
		// Conexion persistente a la base de datos
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// Inicializo la lista vacia
		List<Beacon> beacons = new ArrayList<Beacon>();
		// Creo la consulta para todos los elementos
		Query q = pm.newQuery( Beacon.class );
		try {
			// proceso la data obtenida desde la base de datos
			beacons = ( List<Beacon> ) q.execute(); 
		} finally {
			// Cierro la conexion
			pm.close();
		}
		// Retorno de la data obtenida
		return beacons;
	}
	
	
	/**
	 * Obtiene Beacon por ID específico
	 * @param id
	 * @return
	 */
	public Beacon getById ( Long id ) {
		// Instancio una conexion persistente
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// inicializo el objeto como nulo
		Beacon beacon = null;
		// Genero la clave de búsqueda
		Key key = KeyFactory.createKey(Beacon.class.getSimpleName(), id);
		try {
			// Obtengo el elemento desde la base de datos
			beacon = pm.getObjectById(Beacon.class, key);
		} finally {
			// Cierro la conexión
			pm.close();
		}
		// retorno el objeto obtenido desde BD
		return beacon;
	}
	
	
	/**
	 * Obtiene el beacon asociado a un major y minor
	 * @param major
	 * @param minor
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Beacon getByMajorMinor ( Integer major, Integer minor ) {
		Beacon beacon = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Beacon.class, "minor == " + minor.toString() + " && major == " + major.toString() );
		try {
			List<Beacon> consulta = (List<Beacon>) q.execute();
			if ( ! consulta.isEmpty() && consulta.size() > 0 ) {
				beacon = consulta.get(0);
			} 
		} finally {
			pm.close();
		}
		return beacon;
	}
	
	
	/**
	 * Obtiene la informacion del beacon con el minor, major y UUID
	 * @param major
	 * @param minor
	 * @param uuid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Beacon getByMajorMinorUUID ( Integer major, Integer minor, String uuid ) {
		Beacon beacon = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Beacon.class, "minor == " + minor.toString() + " && major == " + major.toString() + " && uuid == '" + uuid.toString() + "'" );
		try {
			List<Beacon> consulta = (List<Beacon>) q.execute();
			if ( ! consulta.isEmpty() && consulta.size() > 0 ) {
				beacon = consulta.get(0);
			} 
		} catch (Exception e ) {
			
		} finally {
			pm.close();
		}
		return beacon;
	}
	
	
	
	/**
	 * Inserta o actualiza Beacon
	 * @param data
	 * @return
	 */
	public Beacon insertUpdate ( Beacon data ) {
		// Incializo el objeto a retornar
		Beacon beacon = null;
		// Creo una instancia de persistencia a la base de datos
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			// Acciona el guardar o actualizar
			beacon = pm.makePersistent(data);
		} finally {
			// Cierra la conexión
			pm.close();
		}
		// Retorna el objeto
		return beacon;
	}
	
	
	/**
	 * Elimina Beacon
	 * @param id
	 */
	public void delete ( Long id ) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery( Beacon.class );
			q.setFilter("id == idObjeto");
			q.declareParameters("Long idObjeto");
			q.deletePersistentAll( id );
		} finally {
			pm.close();
		}
	}
	
	
	
}
