package com.abir.voiture.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abir.voiture.entities.Vehicule;
import com.abir.voiture.service.VehiculeService;

@Controller
public class VehiculeController {

	@Autowired
	VehiculeService vehiculeService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createVehicule";
	}
	@RequestMapping("/saveVehicule")
	public String saveVehicule(@ModelAttribute("vehicule") Vehicule vehicule,
	                          @RequestParam("date") String date,
	                          ModelMap modelMap) throws ParseException
	                          
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 vehicule.setDateCreation(dateCreation);

	 Vehicule saveVehicule = vehiculeService.saveVehicule(vehicule);
	String msg ="produit enregistré avec Id "+saveVehicule. getIdVehicule();
	modelMap.addAttribute("msg", msg);
	return "createVehicule";

}
	@RequestMapping("/listeVehicule")
	public String listeVehicule(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{ 
		
		Page<Vehicule> a = vehiculeService.getAllVehiculesParPage(page, size);
		modelMap.addAttribute("vehicule", a);
		 modelMap.addAttribute("pages", new int[a.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

	return "listeVehicule";
	}
	@RequestMapping("/supprimerVehicule")
	public String supprimerVehicule(@RequestParam("id") Long id,
	                     ModelMap modelMap,
	                     @RequestParam (name="page",defaultValue = "0") int page,
	                     @RequestParam (name="size", defaultValue = "2") int size)
	{
	vehiculeService.deleteVehiculeById(id);
	Page<Vehicule> a = vehiculeService.getAllVehiculesParPage(page,size);
			modelMap.addAttribute("vehicule", a);
			modelMap.addAttribute("pages", new int[a.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
	  return "listeVehicule";
	}
	@RequestMapping("/modifierVehicule")
	public String editerVehicule(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Vehicule a= vehiculeService.getVehicule(id);
	modelMap.addAttribute("vehicule", a);
	return "EditerArticle";
	}
	@RequestMapping("/updateVehicule")
	public String updateVehicule(@ModelAttribute("vehicule") Vehicule vehicule,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 vehicule.setDateCreation(dateCreation);

	 vehiculeService.updateVehicule(vehicule);
	 List<Vehicule> a = vehiculeService.getAllVehicules();
	 modelMap.addAttribute("vehicule", a);
	return "listeVehicule";
}
}
