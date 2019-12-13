package com.netcracker.services.interfaces;

import com.netcracker.models.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription add(Subscription subscription);
    void delete(int id);
    List<Subscription> findAll(int page, int size);
    Subscription findById(int id);
    List<Subscription> findByUserId(int page, int size, int id);
    int getSize();
    int getSizeByByUserId(int id);

}
