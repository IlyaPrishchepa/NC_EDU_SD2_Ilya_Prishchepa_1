package com.netcracker.repository;

import com.netcracker.entity.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update subscription set status = :status where id = :id")
    void updateStatusById(@Param("id")double id,@Param("status")boolean status);


    List<Subscription> findSubscriptionByUserId(int loginId, Pageable pageable);
}
