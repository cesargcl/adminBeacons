/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 25-08-2015
 * 
 */
package cl.cesarg.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Beacon;
import cl.cesarg.entities.BeaconMessageUser;
import cl.cesarg.model.dao.DaoBeacon;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class BusinessBeacon {

	@Autowired
	private DaoBeacon _daoBeacon;
	
	
	public Beacon insertUpdate (String id, String uuid, String nombre, Integer major, 
								Integer minor, String descripcion, String codeScreen ,
								String mensaje, List<BeaconMessageUser> mensajesPersonalizados) {
		
		Beacon beacon = new Beacon();
		
		if ( id != null ) {
			Long newId = Long.parseLong(id);
			beacon.setId(newId);
		}
		
		beacon.setUuid(uuid);
		beacon.setNombre(nombre);
		beacon.setMajor(major);
		beacon.setMinor(minor);
		beacon.setDescripcion(descripcion);
		beacon.setCodeScreen(codeScreen);
		beacon.setMensaje(mensaje);
		beacon.setMensajesPersonalizados(mensajesPersonalizados);
		
		this._daoBeacon.insertUpdate( beacon );
		
		return beacon;
		
	}
	
	
	/**
	 * Ingresa o actualiza la informacion de un beacon
	 * @param beacon
	 * @return
	 */
	public Beacon insertUpdate ( Beacon beacon) {
		return this._daoBeacon.insertUpdate( beacon );
	}
	
	public Beacon getBeaconMajorMinor (Integer major, Integer minor) {
		return this._daoBeacon.getByMajorMinor(major, minor);
	}
	
	
	/**
	 * Lista completa de Beacons
	 * @return
	 */
	public List<Beacon> getAll () {
		return this._daoBeacon.getAll();
	}
	
	/**
	 * Elimina el beacon de la base de datos
	 * @param beacon
	 */
	public void delete ( Beacon beacon ) {
		this._daoBeacon.delete(beacon.getId());
		
	}
	
	
}
