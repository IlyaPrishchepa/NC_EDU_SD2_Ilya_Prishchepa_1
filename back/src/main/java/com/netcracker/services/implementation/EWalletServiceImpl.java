package com.netcracker.services.implementation;

import com.netcracker.entity.Ewallet;
import com.netcracker.repository.EWalletRepo;
import com.netcracker.services.interfaces.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Ewallet> findByLoginID(int id) {
        return eWalletRepo.findEwalletByLoginId3(id);
    }

    @Override
    public Ewallet replenish(int ewalletId, int amount) {
         Ewallet ewallet = this.findById(ewalletId);
         double oldAmount = ewallet.getAmount();
         ewallet.setAmount(oldAmount+amount);
        return eWalletRepo.save(ewallet);
    }


}
