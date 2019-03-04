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
import org.startup.eformation.dao.ApprenantDAO;
import org.startup.eformation.entities.Apprenant;

@RestController
public class ApprenantServiceREST {
	
	@Autowired
	private ApprenantDAO apprenantdao;
	
	@GetMapping(value="/students")
	public List<Apprenant> getAllApprenant(){
		return apprenantdao.findAll();
	}
	@GetMapping(value="/students/{id}")
	public ResponseEntity<Apprenant> findApprenant(@PathVariable String id) {
		Apprenant found = apprenantdao.getOne(id);
		if (found == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(found);
	}
	@PostMapping(value="/students")
	public ResponseEntity<Void> saveIntervenant(@RequestBody Apprenant apprenant) {
		Apprenant added =  apprenantdao.save(apprenant);
		
		if (added == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(added.getIdApprenant())
					.toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping(value="/students/{id}")
	public boolean deleteIntervenant(@PathVariable String id) {
		apprenantdao.deleteById(id);
		return true;
	}
	@PostMapping(value="/students/{id}")
	public Apprenant updateIntervenant(@PathVariable String id , @RequestBody Apprenant apprenant) {
		apprenant.setIdApprenant(id);
		return apprenantdao.save(apprenant);
	}
	
	
	public ApprenantServiceREST() {
		// TODO Auto-generated constructor stub
	}

}
