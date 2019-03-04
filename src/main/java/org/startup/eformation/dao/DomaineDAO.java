package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Domaine;

@Repository
public interface DomaineDAO extends JpaRepository<Domaine, String> {

}
