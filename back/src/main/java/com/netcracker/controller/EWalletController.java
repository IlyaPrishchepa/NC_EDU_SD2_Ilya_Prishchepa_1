package com.netcracker.controller;

import com.netcracker.entity.Ewallet;
import com.netcracker.services.implementation.EWalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ewallet")
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
