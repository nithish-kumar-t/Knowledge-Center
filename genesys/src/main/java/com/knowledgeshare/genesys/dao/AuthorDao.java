package com.knowledgeshare.genesys.dao;

import com.knowledgeshare.genesys.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends JpaRepository<Author, String> {

    public Author findAuthorByAuthId(String id);
    public List<Author> findAll();

}
