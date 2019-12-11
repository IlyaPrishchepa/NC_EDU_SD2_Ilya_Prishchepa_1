package com.netcracker.controller;

import com.netcracker.models.User;
import com.netcracker.services.implementation.UserServiceImpl;
import com.netcracker.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/find-by-id/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);}

    @GetMapping
    public List<User> findAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return userService.findAll(pageNo, pageSize);
    }

    @GetMapping("/find-by-name/{str}")
    public List<User> findByName(@PathVariable String str) {
        return userService.findByName(str);}

    @GetMapping("/find-by-surname/{str}")
    public List<User> findBySurname(@PathVariable String str) {
        return userService.findBySurname(str);}

    @GetMapping("/find-by-email/{email}")
    public User findByLoginId(@PathVariable String email) {
        return userService.findByEmail(email);}

    @GetMapping("/find-by-loginId/{loginId}")
    public User findByLoginId(@PathVariable int loginId) {
        return userService.findByLoginId(loginId);
    }

    @PostMapping
    public User add(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/size")
    public int getSize() {
        return userService.getSize(); }
}
