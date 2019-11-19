package com.netcracker.services.interfaces;

import com.netcracker.entity.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);
    void delete(int id);
    List<Company> findAll();
    Company findById(int id);
    Company findByName(String name);
}
