/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 23-08-2015
 * 
 */
package cl.cesarg.entities;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@PersistenceCapable
public class Beacon {

	/**
	 * ID unico del beacon
	 */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	

	@Persistent
	private String uuid;
	
	@Persistent
	private String nombre;
	
	@Persistent
	private Integer major;
	
	@Persistent
	private Integer minor;
	
	@Persistent
	private String descripcion;

	@Persistent
	private String codeScreen;
	
	@Persistent
	private String mensaje;
	
	@Persistent(mappedBy = "beacon")
	private List<BeaconMessageUser> mensajesPersonalizados;
	


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the major
	 */
	public Integer getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}

	/**
	 * @return the minor
	 */
	public Integer getMinor() {
		return minor;
	}

	/**
	 * @param minor the minor to set
	 */
	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	/**
	 * @return the mensajesPersonalizados
	 */
	public List<BeaconMessageUser> getMensajesPersonalizados() {
		return mensajesPersonalizados;
	}

	/**
	 * @param mensajesPersonalizados the mensajesPersonalizados to set
	 */
	public void setMensajesPersonalizados(
			List<BeaconMessageUser> mensajesPersonalizados) {
		this.mensajesPersonalizados = mensajesPersonalizados;
	}
		
	
	
}
