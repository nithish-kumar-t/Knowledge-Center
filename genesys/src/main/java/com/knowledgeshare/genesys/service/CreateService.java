package com.knowledgeshare.genesys.service;

import com.knowledgeshare.genesys.entities.*;

public interface CreateService {
    public Author addAuthor(Author author) throws Exception;
    public Customer addCustomer(Customer customer) throws Exception;
    public KnowledgeBase addKnowledgeBase(KnowledgeBase knowledgeBase, String authId) throws Exception;
    public Category addNewCategory(Category category, String knowledgeBaseId, String authId) throws Exception;
    public Document[] addNewDocument(Document[] document, String CategoryName, String knowledgeBaseId, String authId) throws Exception;

}

