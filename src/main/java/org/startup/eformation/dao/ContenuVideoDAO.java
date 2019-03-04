package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.ContenuVideo;

@Repository
public interface ContenuVideoDAO extends JpaRepository<ContenuVideo, Integer> {

}
