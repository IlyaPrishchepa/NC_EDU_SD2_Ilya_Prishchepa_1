package com.netcracker.controller;

import com.netcracker.entity.Login;
import com.netcracker.services.implementation.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping
    public Login create(@RequestBody Login login) {
        return loginService.create(login);
    }

    @GetMapping
    public Login findByEmailAndPassword(@RequestParam String email,@RequestParam String password) {
        return loginService.findByEmailAndPassword(email,password);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        loginService.delete(id);
    }
}
