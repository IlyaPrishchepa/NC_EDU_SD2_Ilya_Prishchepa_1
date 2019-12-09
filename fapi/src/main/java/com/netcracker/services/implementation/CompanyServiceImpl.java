package com.netcracker.services.implementation;

import com.netcracker.models.Company;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public CompanyServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Company save(Company company) {
        return restTemplate.postForObject(backendApiProperties.getCompanyUri(),company,Company.class);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(backendApiProperties.getCompanyUri() + "/" + id);
    }

    @Override
    public List<Company> findAll(int pageNo, int pageSize) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getCompanyUri()
                +"/?pageSize="+pageSize+"&pageNo="+pageNo, Company[].class));
    }

    @Override
    public Company findById(int id) {
        return restTemplate.getForObject(backendApiProperties.getCompanyUri()
                +"/find-by-id/" + id, Company.class);
    }

    @Override
    public Company findByName(String name) {
        return restTemplate.getForObject(backendApiProperties.getCompanyUri()
                +"/find-by-name/" + name, Company.class);
    }
    @Override
    public int getSize(){
        return restTemplate.getForObject(backendApiProperties.getCompanyUri()+"/size", Integer.class);
    }

    @Override
    public Company findByLoginId(int loginId) {
        return restTemplate.getForObject(backendApiProperties.getCompanyUri()
                +"/find-by-loginId/" + loginId, Company.class);
    }
}
