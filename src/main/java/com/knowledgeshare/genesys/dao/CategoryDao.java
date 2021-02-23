package com.knowledgeshare.genesys.dao;

import com.knowledgeshare.genesys.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, String> {
    public Category findCategoriesByName(String name);
}
