package com.netcracker.services.interfaces;

import com.netcracker.entity.Ewallet;

import java.util.List;

public interface EWalletService {

    Ewallet save(Ewallet ewallet);
    void updateAmountById(int id,double amount);
    void delete(int id);
    Ewallet findById(int id);
    List<Ewallet> findByLoginID(int pageNo, int pageSize, int id);
    Ewallet findByLoginID(int id);
    Ewallet replenish(int ewalletId, int amount);
    int getSize();
    int getSizeByLoginId(int id);

}
