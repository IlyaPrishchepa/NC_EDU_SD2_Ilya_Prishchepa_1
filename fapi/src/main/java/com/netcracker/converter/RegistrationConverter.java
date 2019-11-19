package com.netcracker.converter;

import com.netcracker.models.*;

public class RegistrationConverter {

    public User splitRegUserIntoUser (RegUser regUser){
        User user = new User();
        user.setName(regUser.getName());
        user.setSurname(regUser.getSurname());
        return user;
    }

    public Company splitRegCompanyIntoCompany(RegUser regCompany){
        Company company = new Company();
        company.setName(regCompany.getName());
        return company;
    }

    public Login splitRegIntoLogin (RegUser regUser){
        Login login = new Login();
        login.setEmail(regUser.getEmail());
        login.setPassword(regUser.getPassword());
        return login;
    }

    public Login splitRegIntoLogin(RegCompany regCompany){
        Login login = new Login();
        login.setEmail(regCompany.getEmail());
        login.setPassword(regCompany.getPassword());
        return login;
    }

}
