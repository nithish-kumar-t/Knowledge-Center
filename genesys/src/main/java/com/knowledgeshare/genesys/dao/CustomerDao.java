package com.knowledgeshare.genesys.dao;

import com.knowledgeshare.genesys.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {

}
