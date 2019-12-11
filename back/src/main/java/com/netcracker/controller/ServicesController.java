package com.netcracker.controller;

import com.netcracker.entity.Company;
import com.netcracker.entity.Services;
import com.netcracker.services.implementation.ServicesServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/services")
public class ServicesController {
  @Autowired
  private ServicesServiceImpl servicesService;

  @GetMapping
  public List<Services> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
    return servicesService.findAll(pageNo,pageSize);}

  @GetMapping("/size")
  public int getSize() {
    return servicesService.getSize();}

  @GetMapping("/find-by-companyId")
  public List<Services> findByCompanyId(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam int id) {
    return servicesService.findByCompanyId(pageNo,pageSize,id);
  }

  @PostMapping
  public Services save(@RequestBody Services services) {
    return servicesService.add(services);
  }

}
