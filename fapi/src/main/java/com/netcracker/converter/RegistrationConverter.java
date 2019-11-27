package com.netcracker.converter;

import com.netcracker.models.*;
import org.springframework.stereotype.Component;

@Component
public class RegistrationConverter {

    public User splitRegUserIntoUser (RegUser regUser){
        Login login = new Login();
        login.setEmail(regUser.getEmail());
        login.setPassword(regUser.getPassword());

        User user = new User();
        user.setName(regUser.getName());
        user.setSurname(regUser.getSurname());
        user.setLoginId(login);
        return user;
    }

    public Company splitRegCompanyIntoCompany(RegCompany regCompany){
        Login login = new Login();
        login.setEmail(regCompany.getEmail());
        login.setPassword(regCompany.getPassword());

        Company company = new Company();
        company.setName(regCompany.getName());
        company.setLoginId2(login);
        return company;
    }

}
