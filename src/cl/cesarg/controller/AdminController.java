/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 12-10-2015
 * 
 */
package cl.cesarg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cl.cesarg.entities.Administrador;
import cl.cesarg.model.facade.FacadeAdministradores;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Controller
public class AdminController {

	@Autowired
	FacadeAdministradores _facAdministradores;
	
	
	/**
	 * Login de la aplicacion admin
	 */
	@RequestMapping("/admin")
	public String admin ( Model model
						, @RequestParam(value="usuario", required= false) String usuario
						, @RequestParam(value="clave"  , required= false) String clave) {
		
			
		
		return "admin/admin";
	}
	
	
	/**
	 * Login de la aplicacion admin
	 */
	@RequestMapping("/admin/administradores")
	public String administradores ( Model model
								  , @RequestParam(value="id", required= false) Long id
								  , @RequestParam(value="nombre", required = false) String nombre
								  , @RequestParam(value="usuario", required = false) String usuario
								  , @RequestParam(value="clave", required = false) String clave
								  , @RequestParam(value="envio", required = false) String envio
								  , @RequestParam(value="status", required = false) String status
								  , @RequestParam(value="accion", required = false) String accion) {
		
		String mensajeError = "";
		Administrador administrador = new Administrador();
		
		if ( envio != null && envio.equals("1") ) {
		
			if (mensajeError == "" && (nombre == null || nombre.equals("")) ) {
				mensajeError = "Debe ingresar el nombre";
			}
			
			if (mensajeError == "" && (usuario == null || usuario.equals("")) ) {
				mensajeError = "Debe ingresar el usuario";
			}
			
			if (mensajeError == "" && (clave == null || clave.equals("")) ) {
				mensajeError = "Debe ingresar la clave";
			}
			
			if ( mensajeError.equals("") ) {
				
				if ( id > 0 ) {
					administrador.setId( id );
				}	
				
				administrador.setNombre(nombre);
				administrador.setUsuario(usuario);
				administrador.setClave(clave);
				administrador = this._facAdministradores.insertUpdate(administrador);
				
				return "redirect:/admin/administradores?status=ok";
				
			}
			
		}
		
		
		if ( id != null && id != 0 ) {
			if ( accion != null && accion.equals("e") ) {
				this._facAdministradores.delete(id);
				id = null;
			} else {
				administrador = this._facAdministradores.getById(id);
			}
		}
		
		
		
		if ( status != null && status.equals("ok") ) {
			model.addAttribute("mensajeOk", "Los datos han sido guardados correctamente");
		}
		
		model.addAttribute("mensajeError", mensajeError);
		model.addAttribute("id", id);
		model.addAttribute("lstAdministradores", this._facAdministradores.getAll());
		model.addAttribute("administrador", administrador);
		
		return "admin/administradores";
	}
	
	
}
