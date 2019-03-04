package org.startup.eformation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.startup.eformation.dao.ChapitreDAO;
import org.startup.eformation.entities.Chapitre;


@RestController
public class ChapitreServiceREST {
	
	@Autowired
	ChapitreDAO chapitredao;
	
	@GetMapping(value="/chapters")
	public List<Chapitre> getAllChapitre() {
		return chapitredao.findAll();
	}
	
	@PostMapping(value="/chapters")
	public Chapitre saveChapitre(@RequestBody Chapitre chapitre) {
		return chapitredao.save(chapitre);
	}
	
	@DeleteMapping(value="/chapters/{id}")
	public boolean deleteChapitre(@PathVariable String id) {
		chapitredao.deleteById(id);
		return true;
	}
	@PostMapping(value="/chapters/{id}")
	public Chapitre updateChapitre(@PathVariable String id , @RequestBody Chapitre Chapitre) {
		Chapitre.setIdChap(id);
		return chapitredao.save(Chapitre);
	}
	public ChapitreServiceREST() {
		// TODO Auto-generated constructor stub
	}

}
