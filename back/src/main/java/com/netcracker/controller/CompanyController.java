package com.netcracker.controller;

import com.netcracker.entity.Company;
import com.netcracker.services.implementation.CompanyServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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
    public List<Company> findAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return companyService.findAll(pageNo, pageSize);
    }

    @GetMapping("/find-by-id/{id}")
    public Company findById(@PathVariable int id) {
        return companyService.findById(id);
    }

    @GetMapping("/find-by-name/{name}")
    public Company findByName(@PathVariable String name) {
        return companyService.findByName(name);
    }

    @GetMapping("/size")
    public int getSize() {
        return companyService.getSize(); }

}
