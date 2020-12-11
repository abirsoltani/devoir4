package com.abir.voiture.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.abir.voiture.entities.Client;
import com.abir.voiture.entities.Vehicule;
@RepositoryRestResource(path = "rest")
public interface VehiculeRepos extends JpaRepository<Vehicule, Long> {
	List<Vehicule> findByLibelle(String libelle );
	List<Vehicule> findByLibelleContains(String libelle);
	/*@Query("select a from Article a where a.libelle like %?1 and a.prixUnitaire > ?2")
	List<Article> findByLibellePrix (String marque, Double prixVehicule);*/
	@Query("select a from vehicule a where a.marque like %:marque and a.prixVehicule > :prixVehicule")
	List<Vehicule> findByMarquePrix(@Param("marque") String marque,@Param("prixVehicule") Double prixVehicule);
	@Query("select a from vehicule a where a.client = ?1")
	List<Vehicule> findByClient(Client client);
	List<Vehicule> findByClientIdClient(Long id);
	List<Vehicule> findByOrderByMarqueAsc();
	@Query("select a from vehicule a order by a.marque ASC, a.prixVehicule DESC")
	List<Vehicule> trierVehiculesMarquesPrix ();

	}

