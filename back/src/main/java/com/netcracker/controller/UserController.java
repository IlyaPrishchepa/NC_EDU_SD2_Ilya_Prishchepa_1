package com.netcracker.controller;

import com.netcracker.entity.User;
import com.netcracker.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/find-by-id/{id}")
  public User findById(@PathVariable int id) {
    return userService.findById(id);}

  @GetMapping
  public List<User> getAll() {
    return userService.findAll();}

  @GetMapping("/find-by-name/{str}")
  public List<User> findByName(@PathVariable String str) {
    return userService.findByName(str);}

  @GetMapping("/find-by-surname/{str}")
  public List<User> findBySurname(@PathVariable String str) {
    return userService.findBySurname(str);}

  @GetMapping("/find-by-email/{email}")
  public User findByLoginId(@PathVariable String email) {
    return userService.findByEmail(email);}

  @PostMapping
  public User add(@RequestBody User user){
    return userService.save(user);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id){
    userService.delete(id);
  }
}
