/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 22-08-2015
 * 
 */
package cl.cesarg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.cesarg.entities.Beacon;
import cl.cesarg.entities.Messages;
import cl.cesarg.model.facade.FacadeBeacon;
import cl.cesarg.model.facade.FacadePromo;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gson.Gson;



/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Controller
public class WelcomeController {

	@Autowired
	private FacadePromo _facadePromo;
	
	@Autowired
	private FacadeBeacon _facadeBeacon;
	
	
	private String _defaultScreen = "screenDemo2";
	
	
	/**
	 * Visualizador de la informacion gatillada
	 * @param model modelo de los datos a desplegar
	 * @return
	 */
	@RequestMapping( "/" )
	public String welcome ( Model model, @RequestParam( value="token", required=false ) String token ) {
		
		// Asigno la clave a esta pantalla de comunicacion
		if ( token == null ) {
			token = this._defaultScreen;
		}
		
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String tokenScreen = channelService.createChannel ( token );
			
		// asigno el token a la pantalla
		model.addAttribute("tokenScreen", tokenScreen);
		
		// Template de la pantalla
		return "welcome";
	}
	

	/**
	 * Obtiene el objeto beacon en formato JSON
	 * @param major
	 * @param minor
	 * @param uuid
	 * @return
	 */
	@RequestMapping( "/mobile/getBeaconData.json" )
	public @ResponseBody String getBeaconMessage ( @RequestParam (value = "major", required = true) Integer major 
												 , @RequestParam (value = "minor", required = true) Integer minor
												 , @RequestParam (value = "uuid" , required = true) String uuid ) {
		Beacon beacon = this._facadeBeacon.getByMajorMinorUUID(major, minor, uuid);
		Gson gson = new Gson();
		return gson.toJson( beacon );
	}
	
	
	
	/**
	 * Establece la URL de comunicacion con el cliente
	 * @param message
	 * @return
	 */
	@RequestMapping( "/channel" )
	public @ResponseBody String gatillaMensaje (@RequestParam (value = "email", required = false) String email
											  , @RequestParam (value = "major", required = false) Integer major
											  , @RequestParam (value = "minor", required = false) Integer minor) {
		
		String htmlForm = "<form method=\"GET\" action=\"\" >";
		
		if ( email != null && major != null && minor != null ) {
			try {
				Messages mensaje 		= this._facadePromo.mensajePorBeaconUsuario(major, minor, email);
				if ( mensaje != null ) {
					ChannelService channelService = ChannelServiceFactory.getChannelService();
					channelService.sendMessage(new ChannelMessage(mensaje.getCodeScreen(), mensaje.toGson()));
					htmlForm += "<p>mensaje enviado</p>";
				}	
			} catch (Exception error) {
				System.out.println( error.getMessage() );
			}
		}
		
		
		htmlForm += "email : <input name=\"email\" value=\"\" ><br>";
		htmlForm += "major : <input name=\"major\" value=\"\" ><br>";
		htmlForm += "minor : <input name=\"minor\" value=\"\" ><br>";
		htmlForm += "<input type=\"submit\" value=\"enviar\" >";
		htmlForm += "</form><hr>";
		
		return htmlForm;
	}
	
	
	
	
	/**
	 * Llamada al usuario y carga del mensaje con los parametros
	 * @param email
	 * @param major
	 * @param minor
	 * @return
	 */
	@RequestMapping( "/remotepush" )
	public @ResponseBody String push ( @RequestParam (value = "email", required = true) String email
									 , @RequestParam (value = "major", required = true) Integer major
									 , @RequestParam (value = "minor", required = true) Integer minor) {
		
		String retorno = "{\"status\":1}";
		
		Messages mensaje 		= this._facadePromo.mensajePorBeaconUsuario(major, minor, email);
		
		if ( mensaje != null ) {
			ChannelService channelService = ChannelServiceFactory.getChannelService();
			channelService.sendMessage(new ChannelMessage(mensaje.getCodeScreen(), mensaje.toGson()));
			return "{status:0}";
		}
		return retorno;
	}
	
}
