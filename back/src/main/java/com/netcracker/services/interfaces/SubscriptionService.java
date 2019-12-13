package com.netcracker.services.interfaces;

import com.netcracker.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    Subscription add(Subscription subscription);
    void delete(int id);
    List<Subscription> findAll(int page, int size);
    Subscription findById(int id);
    List<Subscription> findByUserId(int page, int size, int id);
    int getSize();
    void updateStatusById(int id,boolean status);
    int getSizeByByUserId(int id);
}
