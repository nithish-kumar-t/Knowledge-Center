package com.knowledgeshare.genesys.controller;

import com.knowledgeshare.genesys.dto.DocumentDto;
import com.knowledgeshare.genesys.entities.*;
import com.knowledgeshare.genesys.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Add {

    @Autowired
    CreateService createService;

    @PostMapping(path = "/add/author")
    public Author addAuthor(@RequestBody Author author) throws Exception {
        return createService.addAuthor(author);
    }

    @PostMapping(path = "/{id}/addKnowledgeBase")
    public KnowledgeBase addKnowledgeBase(@RequestBody KnowledgeBase knowledgeBase,
                                          @PathVariable(name = "id") String authId) throws Exception {
        return createService.addKnowledgeBase(knowledgeBase, authId);
    }

    @PostMapping(path ="/{id}/{knowledgeBaseId}/addCategory")
    public Category addNewCategory(@RequestBody Category category,
                                   @PathVariable String knowledgeBaseId,
                                   @PathVariable(name = "id") String authId) throws Exception {
        return createService.addNewCategory(category, knowledgeBaseId, authId);
    }

    @PostMapping(path = "/{id}/{knowledgeBaseId}/{categoryName}/addDocuments")
    public DocumentDto[] addNewDocument(@RequestBody DocumentDto[] documentDto,
                                   @PathVariable String categoryName,
                                   @PathVariable String knowledgeBaseId,
                                   @PathVariable(name = "id") String authId) throws Exception {
        return createService.addNewDocument(documentDto, categoryName, knowledgeBaseId, authId);
    }

    @PostMapping(path = "/add/customer")
    public Customer addCustomer(Customer customer){
        return customer;
    }


}
