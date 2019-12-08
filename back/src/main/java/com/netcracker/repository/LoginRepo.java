package com.netcracker.repository;

import com.netcracker.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {
    Login findByEmailAndPassword(String email,String password);
    Login findLoginByEmail(String email);
}
