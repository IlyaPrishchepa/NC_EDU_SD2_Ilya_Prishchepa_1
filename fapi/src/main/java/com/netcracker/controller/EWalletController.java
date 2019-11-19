package com.netcracker.controller;

import com.netcracker.models.Ewallet;
import com.netcracker.services.implementation.EWalletServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/ewallet")
@CrossOrigin(origins = "http://localhost:4200")
public class EWalletController {

    @Autowired
    private EWalletServiceImpl eWalletService;

    @PostMapping
    public Ewallet save(@RequestBody Ewallet ewallet) {
        return eWalletService.save(ewallet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        eWalletService.delete(id);

    }

    @GetMapping("/find-by-id/{id}")
    public Ewallet findById(@PathVariable int id) {
        return eWalletService.findById(id);

    }

}
