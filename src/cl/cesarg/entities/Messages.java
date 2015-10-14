/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 23-08-2015
 * 
 */
package cl.cesarg.entities;

import com.google.gson.Gson;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion Objeto que transportará la información obtenida
 * 				al consumidor de la información para finalmente
 * 				darle un formato en JSON, es una clase privada
 * 				para uso interno de la capa de presentación
 *
 */
public class Messages {

	
	private String nombreCliente;
	
	private String message;

	private String codeScreen;
	
	
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the codeScreen
	 */
	public String getCodeScreen() {
		return codeScreen;
	}

	/**
	 * @param codeScreen the codeScreen to set
	 */
	public void setCodeScreen(String codeScreen) {
		this.codeScreen = codeScreen;
	}
	
	
	public String toGson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
}
