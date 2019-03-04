package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Diplome;

@Repository
public interface DiplomeDAO extends JpaRepository<Diplome, Integer> {
	
}
