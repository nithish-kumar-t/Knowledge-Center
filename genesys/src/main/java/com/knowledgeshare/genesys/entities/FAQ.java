package com.knowledgeshare.genesys.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FAQ {
    private String question;
    private String answer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "document_id")
    private Document document;


    @Override
    public String toString() {
        return "FAQ{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", id=" + id +
                ", document=" + document +
                '}';
    }
}
