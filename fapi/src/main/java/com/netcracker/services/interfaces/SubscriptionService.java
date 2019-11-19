package com.netcracker.services.interfaces;

import com.netcracker.models.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription add(Subscription subscription);
    void delete(int id);
    List<Subscription> findAll();
    Subscription findById(int id);
}
