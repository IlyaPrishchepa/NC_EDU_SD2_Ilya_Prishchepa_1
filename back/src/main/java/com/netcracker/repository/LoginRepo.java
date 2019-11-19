package com.netcracker.repository;

import com.netcracker.entity.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends CrudRepository<Login,Integer> {
    Login findByEmail(String email);
}
