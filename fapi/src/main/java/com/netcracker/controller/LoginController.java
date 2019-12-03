package com.netcracker.controller;

import com.netcracker.models.Login;
import com.netcracker.services.implementation.LoginServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping
    public ResponseEntity<Login> create(@RequestBody Login login) {
        if (login != null) {
            return ResponseEntity.ok(loginService.create(login));
        }
        return null;
    }

    @GetMapping
    public ResponseEntity<Login> findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(loginService.findByEmailAndPassword(email,password));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public void delete(@PathVariable int id) {
        loginService.delete(id);
    }
}
