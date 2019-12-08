package com.netcracker.services.interfaces;

import com.netcracker.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User save(User user);
    void delete(int id);
    List<User> findAll();
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    User findById(int id);
    User findByEmail(String email);
    User findByLoginId(int loginId);

}
