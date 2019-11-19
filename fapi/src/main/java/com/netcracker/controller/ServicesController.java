package com.netcracker.controller;
import com.netcracker.models.Services;
import com.netcracker.services.implementation.ServicesServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api
@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicesController {

  @Autowired
  private ServicesServiceImpl servicesService;

  @GetMapping( name = "/", params = {"page","size"})
  public List<Services> getAll(@PathVariable int page, @PathVariable int size) {
    return servicesService.findAll(page, size);}

}
