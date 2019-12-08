package com.netcracker.controller;

import com.netcracker.entity.Login;
import com.netcracker.services.implementation.LoginServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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

    @GetMapping("/find-login-by-email/{email}")
    public Login findLoginByEmail(@PathVariable String email) {
        return loginService.findLoginByEmail(email);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        loginService.delete(id);
    }

    @GetMapping
    public List<Login> findAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return loginService.findAll(pageNo, pageSize);
    }

    @GetMapping("/size")
    public int getSize() {
        return loginService.getSize(); }
}
