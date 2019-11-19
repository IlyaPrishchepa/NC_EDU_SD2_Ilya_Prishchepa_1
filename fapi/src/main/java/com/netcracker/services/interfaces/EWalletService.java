package com.netcracker.services.interfaces;

import com.netcracker.models.Ewallet;

public interface EWalletService {

    Ewallet save(Ewallet ewallet);
    void delete(int id);
    Ewallet findById(int id);

}
