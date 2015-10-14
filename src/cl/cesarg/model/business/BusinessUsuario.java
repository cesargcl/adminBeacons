/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 25-08-2015
 * 
 */
package cl.cesarg.model.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Usuario;
import cl.cesarg.model.dao.DaoUsuario;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class BusinessUsuario {
	
	@Autowired
	private DaoUsuario _daoUsuario;
	
	
	public Usuario insertUpdate (String email, 
								 String first_name, 
								 String last_name, 
								 String middle_name,
								 String gender,
								 String link,
								 String locale,
								 String name,
								 String timezone,
								 String updated_time,
								 String verified,
								 String celular) {
		
		Usuario usuario = new Usuario();
		
		usuario.setKeyString(email);
		usuario.setEmail(email);
		usuario.setFirst_name(first_name);
		usuario.setLast_name(last_name);
		usuario.setMiddle_name(middle_name);
		usuario.setGender(gender);
		usuario.setLink(link);
		usuario.setLocale(locale);
		usuario.setName(name);
		usuario.setTimezone(timezone);
		usuario.setUpdated_time(updated_time);
		usuario.setVerified(verified);
		usuario.setCelular(celular);
			
		this._daoUsuario.insertUpdate(usuario);
		
		return usuario;
		
	}
	
	
	public Usuario getUserByEmail ( String email ) {
		return this._daoUsuario.findByEmail(email);
	}
	
	
	
	
}
