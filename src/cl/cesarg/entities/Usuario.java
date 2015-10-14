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
import com.google.appengine.api.datastore.KeyFactory;

/**
 * 
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion Objeto usuario que almancena la información del usuario
 * 				unico registrado directamente o por red social 
 * 
 */
@PersistenceCapable
public class Usuario {

	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id; // Sera el Email
	
	@Persistent
	private String email;

	@Persistent
	private String first_name;
	
	@Persistent
	private String last_name;
	
	@Persistent
	private String middle_name;
	
	@Persistent
	private String gender;
	
	@Persistent
	private String link;
	
	@Persistent
	private String locale;
	
	@Persistent
	private String name;
	
	@Persistent
	private String timezone;
	
	@Persistent
	private String updated_time;
	
	@Persistent
	private String verified;
	
	@Persistent
	private String celular;
	

	/**
	 * @return the id
	 */
	public Key getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Key id) {
		this.id = id;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}


	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}


	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	/**
	 * @return the middle_name
	 */
	public String getMiddle_name() {
		return middle_name;
	}


	/**
	 * @param middle_name the middle_name to set
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}


	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}


	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}


	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}


	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}


	/**
	 * @return the updated_time
	 */
	public String getUpdated_time() {
		return updated_time;
	}


	/**
	 * @param updated_time the updated_time to set
	 */
	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}


	/**
	 * @return the verified
	 */
	public String getVerified() {
		return verified;
	}


	/**
	 * @param verified the verified to set
	 */
	public void setVerified(String verified) {
		this.verified = verified;
	}


	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}


	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	public void setKeyString ( String key ) {
		Key newKey = KeyFactory.createKey(Usuario.class.getSimpleName(), key);
		this.id = newKey;
	}
	
}
