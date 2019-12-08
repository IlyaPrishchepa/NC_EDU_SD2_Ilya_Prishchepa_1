package com.netcracker.controller;

import com.netcracker.models.Login;
import com.netcracker.services.implementation.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @DeleteMapping
    public void delete(@PathVariable int id) {
        loginService.delete(id);
    }

    @GetMapping("/get-current-login")
    public ResponseEntity<Login> getCurrentLogin(@RequestHeader(value = "Authorization", required = false) String bearerToken) {
        String email = loginService.getEmail(bearerToken);
        return ResponseEntity.ok(loginService.findLoginByEmail(email));
    }

    @GetMapping("/size")
    public int getSize() {
        return loginService.getSize(); }
}
