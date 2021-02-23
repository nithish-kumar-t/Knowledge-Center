package com.knowledgeshare.genesys.service.implement;

import com.knowledgeshare.genesys.dao.*;
import com.knowledgeshare.genesys.entities.*;
import com.knowledgeshare.genesys.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateServiceImpl implements CreateService {

    @Autowired private AuthorDao authorDao;
    @Autowired private KnowledgeBaseDao knowledgeBaseDao;
    @Autowired private CategoryDao categoryDao;
    @Autowired private DocumentDao documentDao;
    @Autowired private CustomerDao customerDao;

    @Override
    public Author addAuthor(Author author) throws Exception {
        if (author.getAuthId() == null || author.getAuthId().isEmpty())
            throw new Exception();

        if (authorDao.findAuthorByAuthId(author.getAuthId()) != null) {
            System.out.println("User With Id Already Exist");
            throw new Exception("Author with Given ID is Already Taken Please Enter a New One. Expected a unique Id");
        }

        authorDao.saveAndFlush(author);
        return author;
    }

    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        if (customer.getCustomId() == null || customer.getCustomId().isEmpty())
            throw new Exception("Customer ID is Null or Empty. Expected a Not Null Value");

        if (customerDao.existsById(customer.getCustomId()))
            throw new Exception("Customer ID is Already Taken Please Enter a New One. Expected a unique Id");

        customerDao.saveAndFlush(customer);
        return customer;
    }

    @Override
    public KnowledgeBase addKnowledgeBase(KnowledgeBase knowledgeBase, String authId) throws Exception {
        if (authId == null || authId.isEmpty())
            throw new Exception("Auth Id Is Null or Empty");

        Author author = authorDao.findAuthorByAuthId(authId);

        if (author == null) {
            System.out.println("No Author with given Id is Found");
            return null;
        }
        if (knowledgeBase.getKnowledgeId() == null || knowledgeBase.getKnowledgeId().isEmpty())
            throw new Exception("Knowledge Id Is Null or Empty");

        knowledgeBaseDao.saveAndFlush(knowledgeBase);

        System.out.println(knowledgeBaseDao.findAll());
        return knowledgeBase;
    }

    @Override
    public Category addNewCategory(Category category, String knowledgeBaseId, String authId) throws Exception {
        if (isAuthIdOrKnowledgeBaseIdNull(knowledgeBaseId, authId)) return null;

        if (category.getName() == null || category.getName().isEmpty())
            throw new Exception("Category name Is Null or Empty");


        category.setKnowledgeBase(knowledgeBaseId);
        categoryDao.save(category);

        System.out.println(knowledgeBaseDao.findAll());
        System.out.println(categoryDao.findAll());

        return category;
    }

    @Override
    public Document[] addNewDocument(Document[] documents, String categoryName, String knowledgeBaseId, String authId) throws Exception {

        if (isAuthIdOrKnowledgeBaseIdNull(knowledgeBaseId, authId))
            return null;

        if (categoryName == null || categoryName.isEmpty())
            throw new Exception("Category name Is Null or Empty");

        for (Document doc : documents) {
            doc.setCategory(categoryName);
            doc.setKnowledgeBase(knowledgeBaseId);
            documentDao.saveAndFlush(doc);
        }

        System.out.println(documentDao.findAll());
        return documents;
    }

    private boolean isAuthIdOrKnowledgeBaseIdNull(String knowledgeBaseId, String authId) throws Exception {
        if (authId == null || authId.isEmpty())
            throw new Exception("Auth Id Is Null or Empty");

        Author author = authorDao.findAuthorByAuthId(authId);

        if (author == null) {
            System.out.println("No Author with given Id is Found");
            return true;
        }

        if (knowledgeBaseId == null || knowledgeBaseId.isEmpty())
            throw new Exception("Knowledge Id Is Null or Empty");
        return false;
    }


}
