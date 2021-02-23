package com.knowledgeshare.genesys.service;

import com.knowledgeshare.genesys.dto.View;
import com.knowledgeshare.genesys.entities.Document;

import java.util.List;

public interface SearchingService {
    public View[] search(String keyword);
    public List<Document> searchByCategoryNameAndKnowledgeBaseId(String categoryName, String knowledgeBaseId);
}
