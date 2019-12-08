package com.netcracker.services.implementation;

import com.netcracker.config.Constants;
import com.netcracker.config.JwtTokenProvider;
import com.netcracker.models.Login;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service("loginService")
public class LoginServiceImpl implements LoginService, UserDetailsService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    private final RestTemplate restTemplate;

    public LoginServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Login create(Login login) {
        login.setPassword(bcryptEncoder.encode(login.getPassword()));
        return restTemplate.postForObject(backendApiProperties.getLoginUri(),login,Login.class);
    }

    @Override
    public Login findByEmailAndPassword(String email, String password) {
        return restTemplate.getForObject(backendApiProperties.getLoginUri()
                +"/?email="+ email + "&password=" + password, Login.class);
    }

    @Override
    public Login findLoginByEmail(String email) {
        return restTemplate.getForObject(backendApiProperties.getLoginUri()
                +"/find-login-by-email/" + email, Login.class);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(backendApiProperties.getLoginUri() + "/" + id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login = findLoginByEmail(email);
        if(login == null){
            throw new UsernameNotFoundException("Invalid login or password!");
        }
        return new User(login.getEmail(), login.getPassword(), getAuthority(login));
    }


    private Set<SimpleGrantedAuthority>  getAuthority(Login login) {
        Set<SimpleGrantedAuthority> authorities = new HashSet();
        authorities.add(new SimpleGrantedAuthority(login.getRole()));
        return authorities;
    }



    public String getEmail(String bearerToken) {
        String email = null;
        String authToken = bearerToken.replace(Constants.TOKEN_PREFIX, "");
        try {
            email = jwtTokenProvider.getUsernameFromToken(authToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }


}
