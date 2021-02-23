package com.knowledgeshare.genesys.dao;

import com.knowledgeshare.genesys.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao  extends JpaRepository<Article, Long> {

}
