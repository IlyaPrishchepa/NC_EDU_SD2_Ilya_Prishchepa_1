package com.netcracker.controller;

import com.netcracker.models.Company;
import com.netcracker.services.implementation.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:4200")
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
        return companyService.findAll(pageNo-1, pageSize);
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

    @GetMapping("/find-by-loginId/{loginId}")
    public Company findByLoginId(@PathVariable int loginId) {
        return companyService.findByLoginId(loginId);
    }

}
