package com.knowledgeshare.genesys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "document")
@Getter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String docType;
    private String param1;
    private String param2;

    @JsonIgnore
    private String category;
    @JsonIgnore
    private String knowledgeBase;

    public Document(String param1, String param2, String type) {
        this.docType = type;
        this.param1 = param1;
        this.param2 = param2;
    }

    public Document() {
        this.docType = "";
        this.param1 = "";
        this.param2 = "";
    }


    public void setCategory(String category){
        this.category = category;
    }

    public void setKnowledgeBase(String knowledgeBase){
        this.knowledgeBase = knowledgeBase;
    }

    @Override
    public String toString() {
        if (this.docType.toLowerCase().equals("faq"))
            return "Document  {" +
                "\n\tdocType = " + docType  +
                ",\n\tquestion = " + param1 +
                ",\n\tanswer = " + param2 +
                "\n}\n";
        return "Document  {" +
                "\n\t docType = " + docType +
                ",\n\t title = " + param1 +
                ",\n\t content = " + param2 +
                "\n}\n ";
    }
}
