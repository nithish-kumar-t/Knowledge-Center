package com.knowledgeshare.genesys.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
    private String title;
    private String content;

    public ArticleDto(String param1, String param2) {
        this.title = param1;
        this.content = param2;
    }
}
