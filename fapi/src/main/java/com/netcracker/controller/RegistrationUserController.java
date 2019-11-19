package com.netcracker.controller;

import com.netcracker.models.Login;
import com.netcracker.models.RegUser;
import com.netcracker.models.User;
import com.netcracker.services.implementation.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/registration-user")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationUserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public User add(@RequestBody RegUser regUser){

        Login login = new Login();
        login.setEmail(regUser.getEmail());
        login.setPassword(regUser.getPassword());

        User user = new User();
        user.setName(regUser.getName());
        user.setSurname(regUser.getSurname());
        user.setLoginId(login);

        return userService.save(user);
    }

}
