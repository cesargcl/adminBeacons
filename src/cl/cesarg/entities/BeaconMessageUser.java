/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 24-08-2015
 * 
 */
package cl.cesarg.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@PersistenceCapable
public class BeaconMessageUser {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	
	@Persistent
	private Beacon beacon;
	
	@Persistent
	private Long idUsuario;
	
	@Persistent
	private String mensaje;

	
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * @return the beacon
	 */
	public Beacon getBeacon() {
		return beacon;
	}

	/**
	 * @param beacon the beacon to set
	 */
	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}
	
	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
