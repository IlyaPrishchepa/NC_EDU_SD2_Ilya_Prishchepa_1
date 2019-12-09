package com.netcracker.repository;

import com.netcracker.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Company findByName(String name);
    Company findCompanyByLoginId2_Id(int loginId);
}
