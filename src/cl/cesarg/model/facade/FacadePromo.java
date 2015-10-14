/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 24-08-2015
 * 
 */
package cl.cesarg.model.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Beacon;
import cl.cesarg.entities.Messages;
import cl.cesarg.entities.Usuario;
import cl.cesarg.model.business.BusinessBeacon;
import cl.cesarg.model.business.BusinessPromo;
import cl.cesarg.model.business.BusinessUsuario;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class FacadePromo {
	
	@Autowired
	private BusinessPromo _businessPromo;
	
	@Autowired
	private BusinessBeacon _businessBeacon;
	
	@Autowired
	private BusinessUsuario _businessUsuario;
	
	
	/**
	 * Obtiene el mensaje personalizado para el usuario
	 * @param major	major asociado al beacon
	 * @param minor	Minor asociado al beacon
	 * @param id	ID de usuario
	 * @return
	 */
	public Messages mensajePorBeaconUsuario ( Integer major, Integer minor, String email ) {
		
		Beacon beacon 			= this._businessBeacon.getBeaconMajorMinor(major, minor);
		Usuario usuario 		= this._businessUsuario.getUserByEmail(email);
		Messages mensajeJson 	= this._businessPromo.getMessagePorUsuarioBeacon(beacon, usuario);
		
		return mensajeJson;
	}
	
	
	
}
