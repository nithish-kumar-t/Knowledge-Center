package com.knowledgeshare.genesys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentDto {
    private String docType;
    private ArticleDto article;
    private FQADto faq;


}
