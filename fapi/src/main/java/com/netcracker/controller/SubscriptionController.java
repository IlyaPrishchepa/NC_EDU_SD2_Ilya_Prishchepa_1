package com.netcracker.controller;

import com.netcracker.models.Subscription;
import com.netcracker.services.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
@CrossOrigin(origins = "http://localhost:4200")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/find-by-userId")
    public List<Subscription> findByUserId(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam int id) {
        return subscriptionService.findByUserId(pageNo-1,pageSize,id);
    }
}
