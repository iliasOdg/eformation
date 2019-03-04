package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Sujet;

@Repository
public interface SujetDAO extends JpaRepository<Sujet, Integer> {

}
