package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.ModuleFormation;

@Repository
public interface ModuleFormationDAO extends JpaRepository<ModuleFormation, String> {

}
