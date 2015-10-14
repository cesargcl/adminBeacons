/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 07-09-2015
 * 
 */
package cl.cesarg.model.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Usuario;
import cl.cesarg.model.business.BusinessUsuario;
import cl.cesarg.model.dao.DaoUsuario;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class FacadeUsuario {

	
	@Autowired
	private BusinessUsuario _businessUsuario;
	
	@Autowired
	private DaoUsuario _daoUsuario;
	
	
	public String registraUsuario (	 String email, 
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

		this._businessUsuario.insertUpdate(email, first_name, last_name, middle_name, gender, link, locale, name, timezone, updated_time, verified, celular);
		return "";
	}
	
	
	public List<Usuario> getAll () {
		return this._daoUsuario.getAll();
	}
}
