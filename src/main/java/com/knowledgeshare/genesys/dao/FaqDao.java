package com.knowledgeshare.genesys.dao;

import com.knowledgeshare.genesys.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqDao  extends JpaRepository<FAQ, Long> {

}
