package com.knowledgeshare.genesys.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class View {
    private String knowledgeBase;
    private Map<String, List<DocumentDto>> categoriesList;


}
