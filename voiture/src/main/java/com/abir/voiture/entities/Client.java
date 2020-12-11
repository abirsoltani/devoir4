package com.abir.voiture.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nom;
	private String prenom; 
	private String adresse;
	 @JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Vehicule> vehicule;
	
	
	public Client(String nom, String prenom, String adresse, List<Vehicule> vehicule) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.vehicule = vehicule;
	}
	public Client() {
		super();
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Vehicule> getArticles() {
		return vehicule;
	}
	public void setArticles(List<Vehicule> vehicule) {
		this.vehicule = vehicule;
	} 
	
}
