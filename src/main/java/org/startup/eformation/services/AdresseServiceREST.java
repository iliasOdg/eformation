package org.startup.eformation.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.startup.eformation.dao.AdresseDAO;
import org.startup.eformation.entities.Adresse;

@RestController
public class AdresseServiceREST {
	
	@Autowired
	AdresseDAO adressedao;
	
	@GetMapping(value="/locations")
	public List<Adresse> getAllLoacation(){
		return adressedao.findAll();
	}
	@GetMapping(value="/locations/{id}")
	public ResponseEntity<Adresse> findAdresse(@PathVariable int id) {
		Adresse found = adressedao.getOne(id);
		if (found == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(found);
	}
	@PostMapping(value="/locations")
	public ResponseEntity<Void> saveAdresse(@RequestBody Adresse adresse) {
		Adresse added =  adressedao.save(adresse);
		
		if (added == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(added.getIdAdr())
					.toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping(value="/locations/{id}")
	public boolean deleteAdresse(@PathVariable int id) {
		adressedao.deleteById(id);
		return true;
	}
	@PostMapping(value="/locations/{id}")
	public Adresse updateDiplome(@PathVariable int id , @RequestBody Adresse adresse) {
		adresse.setIdAdr(id);
		return adressedao.save(adresse);
	}
	
	public AdresseServiceREST() {
		// TODO Auto-generated constructor stub
	}

}
