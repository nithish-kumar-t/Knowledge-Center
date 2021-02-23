package com.knowledgeshare.genesys.servicetest;

import com.knowledgeshare.genesys.dao.*;
import com.knowledgeshare.genesys.dto.DocumentDto;
import com.knowledgeshare.genesys.dto.FQADto;
import com.knowledgeshare.genesys.entities.Author;
import com.knowledgeshare.genesys.entities.Category;
import com.knowledgeshare.genesys.entities.KnowledgeBase;
import com.knowledgeshare.genesys.service.CreateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddServiceTest {
    
    @Autowired CreateService createService;

    @MockBean private AuthorDao authorDao;
    @MockBean private KnowledgeBaseDao knowledgeBaseDao;
    @MockBean private CategoryDao categoryDao;
    @MockBean private DocumentDao documentDao;
    @MockBean private CustomerDao customerDao;

    private Author author;
    private KnowledgeBase knowledgeBase;
    private Category category;
    private DocumentDto documentDto;

    @Before
    public void setUp(){
        author = new Author();
        knowledgeBase = new KnowledgeBase();
        category = new Category();
        documentDto = new DocumentDto();

        author.setName("Author");
        author.setAuthId("119JG67");

        knowledgeBase.setKnowledgeId("banking");
        knowledgeBase.setDescription("ThyView");

        category.setName("investment");

        documentDto.setDocType("faq");
        documentDto.setFaq(new FQADto("", ""));

        when(authorDao.findAuthorByAuthId(author.getAuthId())).thenReturn(author);
    }

    //Checking_Create_Author_Method

    @Test
    public void testCreateAuthorMethod() throws Exception {
        when(authorDao.findAuthorByAuthId(author.getAuthId())).thenReturn(null);
        Author response = createService.addAuthor(author);
        assertEquals(author.getAuthId(), response.getAuthId());
    }

    @Test(expected = Exception.class)
    public void testCreateAuthorMethodWhenUserIDAlreadyExistThenException() throws Exception {
        Author response = createService.addAuthor(author);
        assertEquals(author.getAuthId(), response.getAuthId());
    }

    @Test(expected = Exception.class)
    public void testCreateAuthorMethodWhenAuthIdNull() throws Exception {
        Author tempAuthor = new Author();
        tempAuthor.setName(author.getName());
        createService.addAuthor(tempAuthor);
    }

    //Checking_Adding_KnowledgeBase_Method

    @Test
    public void testAddKnowledgeMethod() throws Exception {
        KnowledgeBase response = createService.addKnowledgeBase(knowledgeBase, author.getAuthId());
        assertEquals(knowledgeBase.getKnowledgeId(), response.getKnowledgeId());
    }

    @Test(expected = Exception.class)
    public void testAddKnowledgeMethodWhenAuthIdNull() throws Exception {
        KnowledgeBase tempBase = new KnowledgeBase();
        tempBase.setKnowledgeId(knowledgeBase.getKnowledgeId());
        createService.addKnowledgeBase(tempBase, "");
    }

    @Test(expected = Exception.class)
    public void testAddKnowledgeMethodWhenKnowledgeIdNull() throws Exception {
        KnowledgeBase tempBase = new KnowledgeBase();
        createService.addKnowledgeBase(tempBase, author.getAuthId());
    }

    //Checking_Adding_KnowledgeBase_Method

    @Test
    public void testAddCategoryForGivenKnowledgeIdMethod() throws Exception {
        Category response = createService.addNewCategory(category, knowledgeBase.getKnowledgeId(), author.getAuthId());
        assertEquals(category.getName(), response.getName());
    }

    @Test(expected = Exception.class)
    public void testAddCategoryMethodWhenAuthIdNull() throws Exception {
        Category tempCategory = new Category();
        tempCategory.setName("");
        createService.addNewCategory(category, knowledgeBase.getKnowledgeId() , "");
    }

    @Test(expected = Exception.class)
    public void testAddCategoryMethodWhenKnowledgeIdNull() throws Exception {
        createService.addNewCategory(category, "" , author.getAuthId());
    }

    @Test(expected = Exception.class)
    public void testAddCategoryMethodWhenCategoryNameNull() throws Exception {
        Category tempCategory = new Category();
        tempCategory.setName("");
        createService.addNewCategory(tempCategory, knowledgeBase.getKnowledgeId() , author.getAuthId());
    }

    //Checking_add_Document_Method

    @Test
    public void testAddDocumentMethod() throws Exception {
        DocumentDto[] documents = new DocumentDto[1];
        documents[0] = documentDto;
        DocumentDto[] response = createService.addNewDocument(documents , category.getName(), knowledgeBase.getKnowledgeId(), author.getAuthId());
    }

    @Test(expected = Exception.class)
    public void testAddDocumentMethodAuthIdNullThenException() throws Exception {
        DocumentDto[] documents = new DocumentDto[1];
        documents[0] = documentDto;
        createService.addNewDocument(documents , category.getName(), knowledgeBase.getKnowledgeId(), "");
    }

    @Test(expected = Exception.class)
    public void testAddDocumentMethodKnowledgeIdNullThenException() throws Exception {
        DocumentDto[] documents = new DocumentDto[1];
        documents[0] = documentDto;
        createService.addNewDocument(documents , category.getName(), "", author.getAuthId());
    }

    @Test(expected = Exception.class)
    public void testAddDocumentMethodCategoryNameNotValid() throws Exception {
        DocumentDto[] documents = new DocumentDto[1];
        documents[0] = documentDto;
        createService.addNewDocument(documents , "", knowledgeBase.getKnowledgeId(), author.getAuthId());
    }


}
