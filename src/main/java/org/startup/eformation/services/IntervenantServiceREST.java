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
import org.startup.eformation.dao.IntervenantDAO;
import org.startup.eformation.entities.Intervenant;

@RestController
public class IntervenantServiceREST {
	
	@Autowired
	private IntervenantDAO intervenantDAO;
	
	@GetMapping(value="/teachers")
	public List<Intervenant> getAllIntervenants(){
		return intervenantDAO.findAll();
	}
	@GetMapping(value="/teachers/{id}")
	public Intervenant findIntervenant(@PathVariable String id) {
		return intervenantDAO.getOne(id);
	}
	@PostMapping(value="/teachers")
	public ResponseEntity<Void> saveIntervenant(@RequestBody Intervenant intv) {
		Intervenant added = intervenantDAO.save(intv);
		if (added == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(added.getIdInterv())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping(value="/teachers/{id}")
	public boolean deleteIntervenant(@PathVariable String id) {
		intervenantDAO.deleteById(id);
		return true;
	}
	@PostMapping(value="/teachers/{id}")
	public Intervenant updateIntervenant(@PathVariable String id , @RequestBody Intervenant intv) {
		intv.setIdInterv(id);
		return intervenantDAO.save(intv);
	}
	
	public IntervenantServiceREST() {
		// TODO Auto-generated constructor stub
	}

}
