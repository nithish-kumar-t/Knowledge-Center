package com.knowledgeshare.genesys.dao;


import com.knowledgeshare.genesys.entities.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeBaseDao extends JpaRepository<KnowledgeBase, String> {
    public KnowledgeBase findKnowledgeBaseByKnowledgeId(String id);
}
