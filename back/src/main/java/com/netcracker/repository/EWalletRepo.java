package com.netcracker.repository;

import com.netcracker.entity.Ewallet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EWalletRepo extends JpaRepository<Ewallet,Integer> {
    List<Ewallet> findEwalletByLoginId3(Pageable pageable, int id);
}
