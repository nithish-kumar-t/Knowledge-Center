package com.knowledgeshare.genesys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FQADto {
    private String question;
    private String answer;

    public FQADto(String param1, String param2) {
        this.question = param1;
        this.answer = param2;
    }
}
