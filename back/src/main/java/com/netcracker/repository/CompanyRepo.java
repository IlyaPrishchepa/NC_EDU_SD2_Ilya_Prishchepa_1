package com.netcracker.repository;

import com.netcracker.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends CrudRepository<Company,Integer> {

    Company findByName(String name);

}
