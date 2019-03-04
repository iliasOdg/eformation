package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Chapitre;

@Repository
public interface ChapitreDAO extends JpaRepository<Chapitre, String> {

}
