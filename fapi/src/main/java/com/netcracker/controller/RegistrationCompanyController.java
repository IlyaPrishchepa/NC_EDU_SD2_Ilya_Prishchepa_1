package com.netcracker.controller;

import com.netcracker.converter.RegistrationConverter;
import com.netcracker.models.Company;
import com.netcracker.models.RegCompany;
import com.netcracker.services.implementation.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration-company")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationCompanyController {
  @Autowired
  private CompanyServiceImpl companyService;
  @Autowired
  private RegistrationConverter converter;

  @PostMapping
  public Company add(@RequestBody RegCompany regCompany){
    return companyService.save(converter.splitRegCompanyIntoCompany(regCompany));
  }
}
