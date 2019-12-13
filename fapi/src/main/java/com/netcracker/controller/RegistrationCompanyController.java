package com.netcracker.controller;

import com.netcracker.converter.RegistrationConverter;
import com.netcracker.models.Company;
import com.netcracker.models.RegCompany;
import com.netcracker.services.implementation.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration-company")
public class RegistrationCompanyController {
  @Autowired
  private CompanyServiceImpl companyService;
  @Autowired
  private RegistrationConverter converter;

  @PostMapping
  public ResponseEntity<Company> add(@RequestBody RegCompany regCompany){
    return  ResponseEntity.ok(companyService.save(converter.splitRegCompanyIntoCompany(regCompany)));
  }
}
