package com.netcracker.services.interfaces;

import com.netcracker.models.User;

import java.util.List;


public interface UserService {

    User save(User user);
    void delete(int id);
    List<User> findAll();
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    User findById(int id);
    User findByEmail(String email);


}
