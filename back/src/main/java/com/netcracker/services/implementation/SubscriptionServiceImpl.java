package com.netcracker.services.implementation;

import com.netcracker.entity.Subscription;
import com.netcracker.repository.SubscriptionRepo;
import com.netcracker.services.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Override
    public Subscription add(Subscription subscription) {
        if (subscription.getStartDate() == null){
            Date date = new Date();
            subscription.setStartDate(date);
            return subscriptionRepo.save(subscription);
        }else{
            return null;
        }
    }

    @Override
    public void delete(int id) {
        subscriptionRepo.deleteById(id);
    }

    @Override
    public List<Subscription> findAll(int pageNo,int pageSize) {
        return (List<Subscription>) subscriptionRepo.
                findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }

    @Override
    public Subscription findById(int id) {
        return subscriptionRepo.findById(id).get();
    }

    @Override
    public List<Subscription> findByUserId(int page, int size, int id) {
        return subscriptionRepo.findSubscriptionByUserId(id, PageRequest.of(page,size));
    }

    @Override
    public int getSize(){
        return (int)subscriptionRepo.count();
    }

    @Override
    public void updateStatusById(int id, boolean status) {
        subscriptionRepo.updateStatusById(id,status);
    }
}
