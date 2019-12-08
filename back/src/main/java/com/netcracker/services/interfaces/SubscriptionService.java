package com.netcracker.services.interfaces;

import com.netcracker.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    Subscription add(Subscription subscription);
    void delete(int id);
    List<Subscription> findAll();
    Subscription findById(int id);
    List<Subscription> findByUserId(int page, int size, int id);
}
