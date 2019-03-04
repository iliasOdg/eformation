package org.startup.eformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.startup.eformation.entities.Forum;

@Repository
public interface ForumDAO extends JpaRepository<Forum, String> {

}
