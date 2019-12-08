package com.netcracker.services.implementation;

import com.netcracker.models.Subscription;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public SubscriptionServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Subscription add(Subscription subscription) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Subscription> findAll(int pageNo, int pageSize) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getSubscriptionUri()
                +"/?pageSize="+pageSize+"&pageNo="+pageNo, Subscription[].class));
    }

    @Override
    public Subscription findById(int id) {
        return null;
    }

    @Override
    public List<Subscription> findByUserId(int pageNo, int pageSize, int id) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getSubscriptionUri()
                + "/find-by-userId?pageNo=" + pageNo+ "&pageSize="+pageSize
                + "&id="+id, Subscription[].class));
    }

    @Override
    public int getSize(){
        return restTemplate.getForObject(backendApiProperties.getSubscriptionUri()+"/size", Integer.class);
    }

}
