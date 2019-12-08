package com.netcracker.repository;

import com.netcracker.entity.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {

    List<Subscription> findSubscriptionByUserId(int loginId, Pageable pageable);
}
