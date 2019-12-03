package com.netcracker.controller;

import com.netcracker.converter.RegistrationConverter;
import com.netcracker.models.RegUser;
import com.netcracker.models.User;
import com.netcracker.services.implementation.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/registration-user")
@CrossOrigin(origins = "http://localhost:4200")
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
