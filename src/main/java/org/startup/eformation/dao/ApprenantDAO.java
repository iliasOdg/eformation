package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Apprenant;

@Repository
public interface ApprenantDAO extends JpaRepository<Apprenant, String> {

}
