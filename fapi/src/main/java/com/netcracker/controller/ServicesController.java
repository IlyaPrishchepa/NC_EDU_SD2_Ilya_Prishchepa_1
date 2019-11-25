package com.netcracker.controller;
import com.netcracker.models.Services;
import com.netcracker.services.implementation.CategoryServiceImpl;
import com.netcracker.services.implementation.CompanyServiceImpl;
import com.netcracker.services.implementation.ServicesServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api
@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicesController {

  @Autowired
  private ServicesServiceImpl servicesService;

  @Autowired
  private CompanyServiceImpl companyService;
  @Autowired
  private CategoryServiceImpl categoryService;

  @GetMapping
  public List<Services> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
    return servicesService.findAll(pageNo,pageSize);}

  @GetMapping("/size")
  public int size(){
    return servicesService.getSize();
  }
}
