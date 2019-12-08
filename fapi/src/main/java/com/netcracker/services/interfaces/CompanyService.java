package com.netcracker.services.interfaces;

import com.netcracker.models.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);
    void delete(int id);
    List<Company> findAll(int page, int size);
    Company findById(int id);
    Company findByName(String name);
    int getSize();
}
