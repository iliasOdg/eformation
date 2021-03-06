package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.InscriptionSession;
import org.startup.eformation.entities.InscriptionSessionPK;

@Repository
public interface InscriptionSessionDAO extends JpaRepository<InscriptionSession, InscriptionSessionPK> {

}
