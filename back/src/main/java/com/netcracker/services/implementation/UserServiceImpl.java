package com.netcracker.services.implementation;

import com.netcracker.entity.User;
import com.netcracker.repository.UserRepo;
import com.netcracker.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User save(User user) {
        return userRepo.save(user);
    }


    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public List<User> findBySurname(String surname) {
        return userRepo.findBySurname(surname);
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User findByLoginId(int loginId) {
        return userRepo.findByLoginId(loginId);
    }
}
