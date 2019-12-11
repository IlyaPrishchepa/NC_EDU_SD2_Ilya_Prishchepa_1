package com.netcracker.repository;

import com.netcracker.entity.Ewallet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EWalletRepo extends JpaRepository<Ewallet,Integer> {
    List<Ewallet> findEwalletByLoginId3(Pageable pageable, int id);

    Ewallet findEwalletByLoginId3(int id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update ewallet set amount = :amount where id = :id")
    void updateAmountById(@Param("id")double id,@Param("amount")double amount);

}
