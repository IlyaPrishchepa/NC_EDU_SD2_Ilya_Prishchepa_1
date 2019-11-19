package com.netcracker.repository;

import com.netcracker.entity.Ewallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EWalletRepo extends CrudRepository<Ewallet,Integer> {

}
