package com.netcracker.repository;

import com.netcracker.entity.Services;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepo extends JpaRepository<Services,Integer> {
    Services findByName(String name);
    List<Services> findServicesByCompanyId(int companyId, Pageable pageable);
    int countServicesByCompanyId(int id);
}
