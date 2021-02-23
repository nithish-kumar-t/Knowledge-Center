package com.knowledgeshare.genesys.service.implement;

import com.knowledgeshare.genesys.dao.CategoryDao;
import com.knowledgeshare.genesys.dao.DocumentDao;
import com.knowledgeshare.genesys.dao.KnowledgeBaseDao;
import com.knowledgeshare.genesys.dto.ArticleDto;
import com.knowledgeshare.genesys.dto.DocumentDto;
import com.knowledgeshare.genesys.dto.FQADto;
import com.knowledgeshare.genesys.dto.View;
import com.knowledgeshare.genesys.entities.Category;
import com.knowledgeshare.genesys.entities.Document;
import com.knowledgeshare.genesys.entities.KnowledgeBase;
import com.knowledgeshare.genesys.service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchingServiceImpl implements SearchingService {
    @Autowired DocumentDao documentDao;
    @Autowired KnowledgeBaseDao knowledgeBaseDao;
    @Autowired CategoryDao categoryDao;

    @Override
    public View[] search(String keyword) {
        List<String> documentList = new ArrayList<>();
        List<View> viewList = new ArrayList<>();

        System.out.println(knowledgeBaseDao.findKnowledgeBaseByKnowledgeId(keyword));

        if (knowledgeBaseDao.findKnowledgeBaseByKnowledgeId(keyword) != null)
            return searchByKnowledgeBase(keyword);


        Map<String, Map<String, List<String>>> hashMap = new HashMap<>();

        for (KnowledgeBase knowledgeBase : knowledgeBaseDao.findAll()){
            View view = new View();
            view.setKnowledgeBase(knowledgeBase.getKnowledgeId());
            Map<String, List<DocumentDto>> map = new HashMap<>();

            for (Category category : categoryDao.findAll()){
                List<DocumentDto> li = new ArrayList<>();
                if (category.getKnowledgeBase().equals(knowledgeBase.getKnowledgeId())){
                    for (Document doc : documentDao.findAll()){
                        if (doc.getKnowledgeBase().equals(knowledgeBase.getKnowledgeId())
                                && doc.getCategory().equals(category.getName())
                                && searchInDocument(doc, keyword)){

                            li.add(getDto(doc));
                        }
                    }
                    if (li.size()>0)
                        map.put(category.getName(), li);
                }

            }
            if (map.size() >0) {
                view.setCategoriesList(map);
                viewList.add(view);
            }

        }

        if (viewList.size() == 0) {
            return new View[0];
        }

        View[] viewArr = new View[viewList.size()];
        int i =0;

        for (View view : viewList){
            viewArr[i++] = view;
        }

        System.out.println(viewList);

        return viewArr;
    }

    private DocumentDto getDto(Document doc){
        DocumentDto dto = new DocumentDto();
        dto.setDocType(doc.getDocType());

        if (dto.getDocType().toLowerCase().equals("faq"))
            dto.setFaq(new FQADto(doc.getParam1(), doc.getParam2()));
        else
            dto.setArticle(new ArticleDto(doc.getParam1(), doc.getParam2()));

        return dto;

    }



    @Override
    public List<DocumentDto> searchByCategoryNameAndKnowledgeBaseId(String categoryName, String knowledgeBaseId ) {
        List<DocumentDto> li = new ArrayList<>();

        for (Document doc : documentDao.findAll()){
            if (doc.getKnowledgeBase().equals(knowledgeBaseId) && doc.getCategory().equals(categoryName)){
                li.add(getDto(doc));
            }
        }

        return li;
    }

    private View[] searchByKnowledgeBase( String key){
        View view = new View();
        view.setKnowledgeBase(key);
        Map<String, List<DocumentDto>> map = new HashMap<>();

        for (Category category : categoryDao.findAll()){
             List<DocumentDto> documentList= searchByCategoryNameAndKnowledgeBaseId(category.getName(), key);

             if (documentList.size() >0)
                 map.put(category.getKnowledgeBase(), documentList);
        }
        view.setCategoriesList(map);

        View[] viewList = new View[1];
        viewList[0] = view;

        return viewList;
    }

    private boolean searchInDocument(Document doc, String key){
        for (String s : doc.getParam1().split(" ") ){
            if (s.toLowerCase().equals(key))
                return true;
        }

        for (String s : doc.getParam2().split(" ") ){
            if (s.toLowerCase().equals(key))
                return true;
        }

        return false;
    }

    private String[] listToArr(List<String> li){
        String[] strings = new String[li.size()];

        int i =0;
        for (String s : li){
            strings[i] = s;
            i++;
        }

        return strings;
    }

}
