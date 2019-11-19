package com.netcracker.controller;

import com.netcracker.models.Company;
import com.netcracker.services.implementation.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping
    public Company create(@RequestBody Company company) {
        return companyService.save(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        companyService.delete(id);
    }

    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Company findById(@PathVariable int id) {
        return companyService.findById(id);
    }

    @GetMapping("/find-by-name/{name}")
    public Company findByName(@PathVariable String name) {
        return companyService.findByName(name);
    }

}
