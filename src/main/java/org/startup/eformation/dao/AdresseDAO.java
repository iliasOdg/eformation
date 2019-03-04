package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Adresse;

@Repository
public interface AdresseDAO extends JpaRepository<Adresse, Integer> {

}
