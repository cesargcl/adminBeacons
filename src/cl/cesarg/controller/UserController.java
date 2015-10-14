/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 05-09-2015
 * 
 */
package cl.cesarg.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cl.cesarg.entities.Usuario;
import cl.cesarg.model.facade.FacadeUsuario;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private FacadeUsuario _facadeUsuario;
	
	
	@RequestMapping("/admin/usuarios")
	public String listaUsuarios  ( Model model ) {
		
		
		
		return "admin/usuarios";
	}
	
	

	@RequestMapping( "/control/register.json" )
	public @ResponseBody String registerFacebookUser ( @RequestParam(value="email", required=true) String email
													 , @RequestParam(value="first_name", required=true) String first_name
													 , @RequestParam(value="last_name", required=true) String last_name
													 , @RequestParam(value="middle_name", required=true) String middle_name
													 , @RequestParam(value="gender", required=true) String gender
													 , @RequestParam(value="link", required=true) String link
													 , @RequestParam(value="locale", required=true) String locale
													 , @RequestParam(value="name", required=true) String name
													 , @RequestParam(value="timezone", required=true) String timezone
													 , @RequestParam(value="updated_time", required=true) String updated_time
													 , @RequestParam(value="verified", required=true) String verified
													 , @RequestParam(value="celular", required=true) String celular) {
		
		return this._facadeUsuario.registraUsuario(email, first_name, last_name, middle_name, gender, link, locale, name, timezone, updated_time, verified, celular);
		
	}
	
	
	@RequestMapping( "/data/users.json" )
	public @ResponseBody String getAllUsers () {
		List<Usuario> data = this._facadeUsuario.getAll();
		Type collectionTime = new TypeToken<List<Usuario>>(){}.getType();
		Gson gson = new Gson();
		return gson.toJson(data, collectionTime);
	}
	
	
}
