package com.netcracker.repository;

import com.netcracker.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services,Integer> {
    Services findByName(String name);
}
