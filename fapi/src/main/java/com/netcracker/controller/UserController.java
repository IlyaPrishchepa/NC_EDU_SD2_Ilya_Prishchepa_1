package com.netcracker.controller;

import com.netcracker.models.User;
import com.netcracker.services.implementation.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/find-by-id/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);}

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();}

    @GetMapping("/find-by-name/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);}

    @GetMapping("/find-by-surname/{surname}")
    public List<User> findBySurname(@PathVariable String surname) {
        return userService.findBySurname(surname);}

    @PostMapping
    public User add(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }


}
