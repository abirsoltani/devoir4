package com.abir.voiture.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.abir.voiture.entities.Client;
import com.abir.voiture.entities.Vehicule;


public interface VehiculeService {
	Vehicule saveVehicule(Vehicule vehicule);
	Vehicule updateVehicule(Vehicule a);
	void deleteVehicule(Vehicule a);
	 void deleteVehiculeById(Long id);
	 Vehicule getVehicule(Long id);
	List<Vehicule> getAllVehicules();
	Page<Vehicule> getAllVehiculesParPage(int page, int size);
	List<Vehicule> findByLibelle(String libelle);
	List<Vehicule> findByLibelleContains(String libelle);
	List<Vehicule> findByLibellePrix(String libelle, Double prix);
	List<Vehicule> findByClient (Client client);
	List<Vehicule> findByClientIdClient(Long id);
	List<Vehicule> findByOrderByLibelleAsc();
	List<Vehicule> trierLibellePrix();
}
