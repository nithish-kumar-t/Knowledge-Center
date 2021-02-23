package com.knowledgeshare.genesys.service;

import com.knowledgeshare.genesys.dto.DocumentDto;
import com.knowledgeshare.genesys.dto.View;

import java.util.List;

public interface SearchingService {
    public View[] search(String keyword);
    public List<DocumentDto> searchByCategoryNameAndKnowledgeBaseId(String categoryName, String knowledgeBaseId);
}
