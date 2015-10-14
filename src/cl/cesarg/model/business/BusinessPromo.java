/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 24-08-2015
 * 
 */
package cl.cesarg.model.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Beacon;
import cl.cesarg.entities.Messages;
import cl.cesarg.entities.Usuario;
import cl.cesarg.model.dao.DaoBeacon;
import cl.cesarg.model.dao.DaoUsuario;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class BusinessPromo {

	@Autowired
	private DaoBeacon _daoBeacon;
	
	@Autowired
	private DaoUsuario _daoUsuario;
	
	
	public Messages getMessagePorUsuarioBeacon ( Beacon beacon, Usuario usuario ) {
		
		Messages mensaje = new Messages();
		mensaje.setMessage( beacon.getMensaje() );
		if ( usuario != null ) {
			mensaje.setNombreCliente(usuario.getName());
		} else {
			mensaje.setNombreCliente("");
		}
		mensaje.setCodeScreen( beacon.getCodeScreen() );
		return mensaje;
	}
	
	
	public void save ( Beacon beacon ) {
		this._daoBeacon.insertUpdate(beacon);
	}
	
}
