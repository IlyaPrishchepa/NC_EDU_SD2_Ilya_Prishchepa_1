package com.netcracker.services.implementation;

import com.netcracker.models.Category;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public CategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Category add(Category category) {
        return restTemplate.postForObject(backendApiProperties.getCategoryUri(), category, Category.class);
    }

    @Override
    public void deleteByID(int id) {
        restTemplate.delete(backendApiProperties.getCategoryUri() + "/" + id);
    }

    @Override
    public List<Category> findAll() {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getCategoryUri(), Category[].class));
    }

    @Override
    public Category findById(int id) {
        return restTemplate.getForObject(backendApiProperties.getCategoryUri()
                +"/" + id, Category.class);
    }
}
