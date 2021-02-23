package com.knowledgeshare.genesys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {

    private String name;
    @Id
    @Column(nullable = false)
    private String authId;

    @Override
    public String toString() {
        return "Author{" +
                ", name='" + name + '\'' +
                ", authId='" + authId + '\'' +
                '}';
    }
}

