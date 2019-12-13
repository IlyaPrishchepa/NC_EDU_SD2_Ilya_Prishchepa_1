package com.netcracker.controller;

import com.netcracker.entity.Company;
import com.netcracker.entity.Subscription;
import com.netcracker.services.implementation.SubscriptionServiceImpl;
import com.netcracker.services.interfaces.SubscriptionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/find-by-userId")
    public List<Subscription> findByUserId(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam int id) {
        return subscriptionService.findByUserId(pageNo,pageSize,id);
    }

    @GetMapping
    public List<Subscription> findAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return subscriptionService.findAll(pageNo, pageSize);
    }

    @GetMapping("/size")
    public int getSize() {
        return subscriptionService.getSize(); }

    @PostMapping
    public Subscription add(@RequestBody Subscription subscription) {
        return subscriptionService.add(subscription);
    }

    @GetMapping("/size-by-userId/{id}")
    public int getSizeByUserId(@PathVariable int id) {
        return subscriptionService.getSizeByByUserId(id);
    }
}
