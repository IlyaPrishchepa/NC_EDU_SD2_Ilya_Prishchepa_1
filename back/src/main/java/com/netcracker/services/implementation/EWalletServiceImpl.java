package com.netcracker.services.implementation;

import com.netcracker.entity.Ewallet;
import com.netcracker.repository.EWalletRepo;
import com.netcracker.services.interfaces.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EWalletServiceImpl implements EWalletService {

    @Autowired
    private EWalletRepo eWalletRepo;

    @Override
    public Ewallet save(Ewallet ewallet) {
        return eWalletRepo.save(ewallet);
    }

    @Override
    public void delete(int id) {
        eWalletRepo.deleteById(id);

    }

    @Override
    public Ewallet findById(int id) {
        return eWalletRepo.findById(id).get();

    }
}
