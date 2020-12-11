package com.abir.voiture.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "marque", types = { Vehicule.class })
public interface VehiculeProjection {
	public String getLibelle();

}