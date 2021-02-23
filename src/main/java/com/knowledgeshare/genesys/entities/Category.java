package com.knowledgeshare.genesys.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @Column(nullable = false)
    private String name;

    private String knowledgeBase;

    public Category(String categoryName) {
        this.name = categoryName;
    }

    public Category(){
        this.name = "";
    }


    @Override
    public String toString() {
        return "Category{" +
                ", name='" + name + '\'' +
                ", knowledgeBase=" + knowledgeBase +
                '}';
    }
}
