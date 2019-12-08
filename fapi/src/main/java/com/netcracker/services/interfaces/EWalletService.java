package com.netcracker.services.interfaces;

import com.netcracker.models.Ewallet;

import java.util.List;

public interface EWalletService {

    Ewallet save(Ewallet ewallet);
    void delete(int id);
    Ewallet findById(int id);
    List<Ewallet> findByLoginID(int id);
    Ewallet replenish(int ewalletId, int amount);

}
