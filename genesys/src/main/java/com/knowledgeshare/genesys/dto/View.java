package com.knowledgeshare.genesys.dto;

import com.knowledgeshare.genesys.entities.Document;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class View {

    private String knowledgeBase;
    private Map<String, List<Document>> categoriesList;



}
