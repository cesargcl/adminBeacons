/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 05-09-2015
 * 
 */
package cl.cesarg.model.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cesarg.entities.Beacon;
import cl.cesarg.model.business.BusinessBeacon;
import cl.cesarg.model.dao.DaoBeacon;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Component
public class FacadeBeacon {
	
	@Autowired
	BusinessBeacon _businessBeacon;
	
	@Autowired
	DaoBeacon _daoBeacon;
	
	
	public List<Beacon> getAll () {
		return this._businessBeacon.getAll();
	}
	
	public Beacon saveUpdate ( Beacon beacon ) {
		return this._businessBeacon.insertUpdate(beacon);
	}

	public Beacon delete ( Beacon beacon ) {
		this._businessBeacon.delete(beacon);
		return beacon;
	}
	
	public Beacon getByMajorMinorUUID ( Integer major, Integer minor, String uuid ) {
		return this._daoBeacon.getByMajorMinorUUID(major, minor, uuid);
	}
	
	
}
