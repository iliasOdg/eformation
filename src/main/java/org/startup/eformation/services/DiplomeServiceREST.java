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
import org.startup.eformation.dao.DiplomeDAO;
import org.startup.eformation.entities.Diplome;

@RestController
public class DiplomeServiceREST {
	@Autowired
	DiplomeDAO diplomedao;
	
	@GetMapping(value="/diploma")
	public List<Diplome> getAllDiplome(){
		return diplomedao.findAll();
	}
	@GetMapping(value="/diploma/{id}")
	public ResponseEntity<Diplome> findDiplome(@PathVariable int id) {
		Diplome found = diplomedao.getOne(id);
		if (found == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(found);
	}
	@PostMapping(value="/diploma")
	public ResponseEntity<Void> saveDiplome(@RequestBody Diplome diplome) {
		Diplome added =  diplomedao.save(diplome);
		
		if (added == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(added.getIdDiplome())
					.toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping(value="/diploma/{id}")
	public boolean deleteDiplome(@PathVariable int id) {
		diplomedao.deleteById(id);
		return true;
	}
	@PostMapping(value="/diploma/{id}")
	public Diplome updateDiplome(@PathVariable int id , @RequestBody Diplome diplome) {
		diplome.setIdDiplome(id);
		return diplomedao.save(diplome);
	}
	
	public DiplomeServiceREST() {
		// TODO Auto-generated constructor stub
	}

}
