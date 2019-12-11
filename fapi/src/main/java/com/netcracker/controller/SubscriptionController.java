package com.netcracker.controller;

import com.netcracker.models.Subscription;
import com.netcracker.services.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public Subscription add(@RequestBody Subscription subscription) {
        return subscriptionService.add(subscription);
    }

    @GetMapping("/find-by-userId")
    public List<Subscription> findByUserId(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam int id) {
        return subscriptionService.findByUserId(pageNo-1,pageSize,id);
    }

    @GetMapping
    public List<Subscription> findAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return subscriptionService.findAll(pageNo, pageSize);
    }

    @GetMapping("/size")
    public int getSize() {
        return subscriptionService.getSize(); }
}
