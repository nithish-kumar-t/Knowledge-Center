package com.knowledgeshare.genesys.controller;

import com.knowledgeshare.genesys.dto.View;
import com.knowledgeshare.genesys.service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Search {

    @Autowired SearchingService search;

    @GetMapping("/search/{key}")
    public View[] search(@PathVariable(name = "key") String keyword){
        return search.search(keyword);
    }

}
