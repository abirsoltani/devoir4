package com.abir.voiture;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.abir.voiture.entities.Client;
import com.abir.voiture.entities.Vehicule;
import com.abir.voiture.repos.VehiculeRepos;
import com.abir.voiture.service.VehiculeService;

@SpringBootTest
class VehiculeApplicationTests {

	@Autowired
	private VehiculeRepos vehiculeRepository;
	@Autowired
	private VehiculeService vehiculeService;
	
	@Test
	public void testCreateVehicule() {
	Vehicule prod = new Vehicule("kia","rouge",1500.500,new Date());
	vehiculeRepository.save(prod);
	}
	
	@Test
	public void testFindVehicule()
	{
	Vehicule p = vehiculeRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateVehicule()
	{
	Vehicule p = vehiculeRepository.findById(1L).get();
	p.setPrixVehicule(2000.0);
	vehiculeRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteVehicule()
	{
		vehiculeRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllVehicule()
	{
		List<Vehicule> prods = vehiculeRepository.findAll();
		
		for (Vehicule p:prods)
			 System.out.println(p);
		
	}
	@Test
	 public void testFindByLibelleContains()
	 {
	 Page<Vehicule> a = vehiculeService.getAllVehiculesParPage(0,2);
	 System.out.println(a.getSize());
	 System.out.println(a.getTotalElements());
	 System.out.println(a.getTotalPages());
	 a.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	
	 }
	 @Test
	 public void testFindVehiculeByNom()
	 {
	 List<Vehicule> arts = vehiculeRepository.findByLibelle("PC");
	 for(Vehicule a:arts) {
	 System.out.println(a);}
	 }
	 @Test
	 public void testFindVehiculeByNomContains()
	 {
	 List<Vehicule> arts = vehiculeRepository.findByLibelleContains("e");
	 for(Vehicule a:arts) {
	 System.out.println(a);}
	 }
	 @Test
	 public void testfindByMarquePrix()
	 {
	 List<Vehicule> arts = vehiculeRepository.findByMarquePrix("BMW",22.200);
	 for (Vehicule a : arts)
	 {
	 System.out.println(a);
	 }
	 }
	 
	 @Test
		public void testfindByClient()
		{
		Client cl = new Client();
		cl.setIdClient(1L);
		List<Vehicule> arts = vehiculeRepository.findByClient(cl);
		for (Vehicule a : arts)
		{
		System.out.println(a);
		}
}
	 @Test
	 public void findByClientIdClient()
	 {
	 List<Vehicule> arts = vehiculeRepository.findByClientIdClient(1L);
	 for (Vehicule a : arts)
	 {
	 System.out.println(a);
	 }
	  }
	 @Test
	 public void testfindByOrderByLibelleAsc()
	 {
	 List<Vehicule> arts =
	  vehiculeRepository.findByOrderByMarqueAsc();
	 for (Vehicule a : arts)
	 {
	 System.out.println(a);
	 }
	 }
	 @Test
	 public void testTrierVehiculesLibellePrix()
	 {
	 List<Vehicule> arts = vehiculeRepository.trierVehiculesMarquesPrix();
	 for (Vehicule a : arts)
	 {
	 System.out.println(a);
	 }
	 }
	

}

