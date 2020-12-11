package com.abir.voiture.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abir.voiture.entities.Vehicule;
import com.abir.voiture.service.VehiculeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VehiculeRESTController {
	@Autowired
	VehiculeService vehiculeService;
	@RequestMapping(method=RequestMethod.GET)
	public List<Vehicule> getAllArticles(){
		return vehiculeService.getAllVehicules();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Vehicule getVehiculeById(@PathVariable("id") Long id) {
	return vehiculeService.getVehicule(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Vehicule createAVehicule(@RequestBody Vehicule vehicule) {
	return vehiculeService.saveVehicule(vehicule);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
	return vehiculeService.updateVehicule(vehicule);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVehicule(@PathVariable("id") Long id)
	{
		vehiculeService.deleteVehiculeById(id);
	}
	@RequestMapping(value="/articleclt/{idClient}",method = RequestMethod.GET)
	public List<Vehicule> getArticlesByClientId(@PathVariable("idClient") Long id) {
	return vehiculeService.findByClientIdClient(id);
	}
	
}
