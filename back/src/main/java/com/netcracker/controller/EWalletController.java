package com.netcracker.controller;

import com.netcracker.entity.Ewallet;
import com.netcracker.services.implementation.EWalletServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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

    @GetMapping("/find-by-loginId/{id}")
    public List<Ewallet> findByLoginId(@PathVariable int id) {
        return eWalletService.findByLoginID(id);
    }

    @GetMapping()
    public Ewallet replenish(@RequestParam int  ewalletId, @RequestParam int amount) {
        return eWalletService.replenish(ewalletId,amount);}

}
