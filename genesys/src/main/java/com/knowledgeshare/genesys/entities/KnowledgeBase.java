package com.knowledgeshare.genesys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "knowledgeBase")
@Getter
@Setter
public class KnowledgeBase {

    @Id
    @Column(nullable = false)
    private String knowledgeId;
    private String description;


    @Override
    public String toString() {
        return "KnowledgeBase{" +
                ", knowledgeId='" + knowledgeId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

