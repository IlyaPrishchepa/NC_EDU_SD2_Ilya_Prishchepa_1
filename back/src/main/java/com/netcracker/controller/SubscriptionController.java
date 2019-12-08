package com.netcracker.controller;

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
}
