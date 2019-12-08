package com.netcracker.services.implementation;

import com.netcracker.entity.Subscription;
import com.netcracker.repository.SubscriptionRepo;
import com.netcracker.services.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Override
    public Subscription add(Subscription subscription) {
        return subscriptionRepo.save(subscription);
    }

    @Override
    public void delete(int id) {
        subscriptionRepo.deleteById(id);
    }

    @Override
    public List<Subscription> findAll() {
        return (List<Subscription>) subscriptionRepo.findAll();
    }

    @Override
    public Subscription findById(int id) {
        return subscriptionRepo.findById(id).get();
    }

    @Override
    public List<Subscription> findByUserId(int page, int size, int id) {
        return subscriptionRepo.findSubscriptionByUserId(id, PageRequest.of(page,size));
    }
}
