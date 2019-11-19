package com.netcracker.controller;

import com.netcracker.entity.Services;
import com.netcracker.services.implementation.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
  @Autowired
  private ServicesServiceImpl servicesService;

  @GetMapping( value = "/", params = {"page","size"})
  public List<Services> getAll(@RequestParam int page, @RequestParam int size) {
    return servicesService.findAll(page,size);}

}
