package com.knowledgeshare.genesys.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    private String name;

    @Id
    private String customId;

}
