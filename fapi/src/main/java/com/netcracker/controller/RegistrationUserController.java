package com.netcracker.controller;

import com.netcracker.converter.RegistrationConverter;
import com.netcracker.models.RegUser;
import com.netcracker.models.User;
import com.netcracker.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration-user")
public class RegistrationUserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RegistrationConverter converter;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody RegUser regUser){
        return ResponseEntity.ok(userService.save(converter.splitRegUserIntoUser(regUser)));
    }

}
