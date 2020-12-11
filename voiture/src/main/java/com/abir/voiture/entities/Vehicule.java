package com.abir.voiture.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehicule;
	private String marque;
	private String couleur;
	private Double prixVehicule;
	private Date dateCreation;
	@ManyToOne
	private Client client;
	
	
	public Vehicule() {
		super();
	}
	
	public Vehicule(String marque, String couleur, Double prixVehicule, Date dateCreation) {
		super();
		this.marque = marque;
		this.couleur = couleur;
		this.prixVehicule = prixVehicule;
		this.dateCreation = dateCreation;
	}

	public Long getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(Long idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public Double getPrixVehicule() {
		return prixVehicule;
	}
	public void setPrixVehicule(Double prixVehicule) {
		this.prixVehicule = prixVehicule;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Vehicule [idVehicule=" + idVehicule + ", marque=" + marque + ", couleur=" + couleur + ", prixVehicule="
				+ prixVehicule + ", dateCreation=" + dateCreation + "]";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	}