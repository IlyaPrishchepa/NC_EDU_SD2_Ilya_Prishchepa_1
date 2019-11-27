package com.netcracker.controller;

import com.netcracker.models.Login;
import com.netcracker.services.implementation.LoginServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping
    public Login create(@RequestBody Login login) {
        return loginService.create(login);
    }

    @GetMapping
    public Login findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return loginService.findByEmailAndPassword(email,password);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        loginService.delete(id);
    }
}
