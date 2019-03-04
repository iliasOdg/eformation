package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Document;

@Repository
public interface DocumentsDAO extends JpaRepository<Document, Integer> {

}
