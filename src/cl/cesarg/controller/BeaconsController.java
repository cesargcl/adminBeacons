/**
 * @autor Cesar Gonzalez Molina
 * @email cesar@cesarg.cl
 * @twitter http://twitter.com/donpandix
 *
 * Version 1.0 04-09-2015
 * 
 */
package cl.cesarg.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cl.cesarg.entities.Beacon;
import cl.cesarg.model.facade.FacadeBeacon;

/**
 * @author 		Cesar Gonzalez Molina @donpandix
 * @descripcion 
 *
 */
@Controller
public class BeaconsController {

	
	@Autowired
	FacadeBeacon _facadeBeacon;
	
	
	@RequestMapping( "/admin/beacons" )
	public String beaconHomeAdmin ( Model model ) {
		// Abre la pagina HTML
		return "admin/beacons";
	}
	
	
	@RequestMapping( "/data/beacons.json" )
	public @ResponseBody String all (Model model) {
		List<Beacon> data = this._facadeBeacon.getAll();
		Type collectionTime = new TypeToken<List<Beacon>>(){}.getType();
		Gson gson = new Gson();
		return gson.toJson(data, collectionTime);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping( "/data/beacons/update.json" )
	public @ResponseBody String update (Model model, @RequestParam( value="models", required=true ) String models) {

		Type collectionTime = new TypeToken<List<Beacon>>(){}.getType();
		Gson gson = new Gson();
		
		List<Beacon> beacons = (List<Beacon>) gson.fromJson(models, collectionTime);
		List<Beacon> retorno = new ArrayList<Beacon>();
		for ( Beacon beacon : beacons ) {
			retorno.add(this._facadeBeacon.saveUpdate(beacon));
		} 
		
		return gson.toJson(retorno, collectionTime);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping( "/data/beacons/destroy.json")
	public @ResponseBody String destroy (Model model, @RequestParam( value="models", required=true ) String models) {
		
		Type collectionTime = new TypeToken<List<Beacon>>(){}.getType();
		Gson gson = new Gson();
		List<Beacon> beacons = (List<Beacon>) gson.fromJson(models, collectionTime);
		List<Beacon> retorno = new ArrayList<Beacon>();
		for ( Beacon beacon : beacons ) {
			retorno.add(this._facadeBeacon.delete(beacon));
		} 
		return gson.toJson(retorno, collectionTime);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping( "/data/beacons/create.json" )
	public @ResponseBody String create (Model model, @RequestParam( value="models", required=true ) String models) {
		
		Type collectionTime = new TypeToken<List<Beacon>>(){}.getType();
		Gson gson = new Gson();
		
		List<Beacon> beacons = (List<Beacon>) gson.fromJson(models, collectionTime);
		List<Beacon> retorno = new ArrayList<Beacon>();
		for ( Beacon beacon : beacons ) {
			retorno.add(this._facadeBeacon.saveUpdate(beacon));
		} 
		
		return gson.toJson(retorno, collectionTime);
	}
	
	
	
}



















