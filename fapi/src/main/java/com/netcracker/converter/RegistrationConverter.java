package com.netcracker.converter;

import com.netcracker.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegistrationConverter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User splitRegUserIntoUser (RegUser regUser){
        Login login = new Login();
        login.setEmail(regUser.getEmail());
        login.setRole("USER");
        login.setPassword(passwordEncoder.encode(regUser.getPassword()));

        User user = new User();
        user.setName(regUser.getName());
        user.setSurname(regUser.getSurname());
        user.setLoginId(login);
        return user;
    }

    public Company splitRegCompanyIntoCompany(RegCompany regCompany){
        Login login = new Login();
        login.setEmail(regCompany.getEmail());
        login.setRole("COMPANY");
        login.setPassword(passwordEncoder.encode(regCompany.getPassword()));

        Company company = new Company();
        company.setName(regCompany.getName());
        company.setLoginId2(login);
        return company;
    }

}
