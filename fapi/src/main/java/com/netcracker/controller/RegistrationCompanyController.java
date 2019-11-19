package com.netcracker.controller;

import com.netcracker.models.Company;
import com.netcracker.models.Login;
import com.netcracker.models.RegCompany;
import com.netcracker.services.implementation.CompanyServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/registration-company")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationCompanyController {
  @Autowired
  private CompanyServiceImpl companyService;

  @PostMapping
  public Company add(@RequestBody RegCompany regCompany){

    Login login = new Login();
    login.setEmail(regCompany.getEmail());
    login.setPassword(regCompany.getPassword());

    Company company = new Company();
    company.setName(regCompany.getName());
    company.setLoginId2(login);

    return companyService.save(company);
  }
}
