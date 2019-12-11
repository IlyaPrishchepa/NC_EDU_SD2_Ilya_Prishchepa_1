package com.netcracker.controller;
import com.netcracker.models.Services;
import com.netcracker.services.implementation.CategoryServiceImpl;
import com.netcracker.services.implementation.CompanyServiceImpl;
import com.netcracker.services.implementation.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

  @Autowired
  private ServicesServiceImpl servicesService;

  @Autowired
  private CompanyServiceImpl companyService;
  @Autowired
  private CategoryServiceImpl categoryService;

  @GetMapping
  public List<Services> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
    return servicesService.findAll(pageNo-1,pageSize);}

  @GetMapping("/size")
  public int size(){
    return servicesService.getSize();
  }

  @GetMapping("/find-by-companyId")
  public List<Services> findByCompanyId(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam int id) {
    return servicesService.findByCompanyId(pageNo-1,pageSize,id);
  }

  @PostMapping
  public Services save(@RequestBody Services services) {
    return servicesService.add(services);
  }
}
