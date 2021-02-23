package com.knowledgeshare.genesys.dao;

import com.knowledgeshare.genesys.entities.Category;
import com.knowledgeshare.genesys.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDao extends JpaRepository<Document, Long> {

}
