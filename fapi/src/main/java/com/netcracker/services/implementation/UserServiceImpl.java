package com.netcracker.services.implementation;

import com.netcracker.models.Subscription;
import com.netcracker.models.User;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public User save(User user) {
        return restTemplate.postForObject(backendApiProperties.getUserUri(), user, User.class);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(backendApiProperties.getUserUri() + "/" + id);

    }

    @Override
    public List<User> findAll(int pageNo, int pageSize) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/?pageSize="+pageSize+"&pageNo="+pageNo, User[].class));
    }

    @Override
    public List<User> findByName(String name) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/find-by-name/" + name, User[].class));
    }

    @Override
    public List<User> findBySurname(String surname) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/find-by-surname/" + surname, User[].class));
    }

    @Override
    public User findById(int id) {
        return restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/find-by-id/" + id, User.class);
    }

    @Override
    public User findByEmail(String email) {
        return restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/find-by-email/" + email, User.class);
    }

    @Override
    public User findByLoginId(int loginId) {
        return restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/find-by-loginId/" + loginId, User.class);
    }

    @Override
    public int getSize(){
        return restTemplate.getForObject(backendApiProperties.getUserUri()+"/size", Integer.class);
    }
}
