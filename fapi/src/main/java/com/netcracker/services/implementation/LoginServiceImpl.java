package com.netcracker.services.implementation;

import com.netcracker.models.Login;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public LoginServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Login create(Login login) {
        return restTemplate.postForObject(backendApiProperties.getLoginUri(),login,Login.class);
    }

    @Override
    public Login findByEmailAndPassword(String email, String password) {
        return restTemplate.getForObject(backendApiProperties.getLoginUri()
                +"/?email="+ email + "&password=" + password, Login.class);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(backendApiProperties.getLoginUri() + "/" + id);
    }
}
