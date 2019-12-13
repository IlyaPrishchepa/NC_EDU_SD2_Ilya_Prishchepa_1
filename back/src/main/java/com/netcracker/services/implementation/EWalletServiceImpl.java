package com.netcracker.services.implementation;

import com.netcracker.entity.Ewallet;
import com.netcracker.repository.EWalletRepo;
import com.netcracker.services.interfaces.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EWalletServiceImpl implements EWalletService {

    @Autowired
    private EWalletRepo eWalletRepo;

    @Override
    public Ewallet save(Ewallet ewallet) {
        return eWalletRepo.save(ewallet);
    }

    @Override
    public void updateAmountById(int id,double amount) {
        eWalletRepo.updateAmountById(id,amount);
    }

    @Override
    public void delete(int id) {
        eWalletRepo.deleteById(id);

    }

    @Override
    public Ewallet findById(int id) {
        Optional<Ewallet> wallet = eWalletRepo.findById(id);
        if (wallet.isPresent()) {
            return wallet.get();
        }
        return null;
    }

    @Override
    public List<Ewallet> findByLoginID(int pageNo, int pageSize,int id) {
        return eWalletRepo.findEwalletByLoginId3(PageRequest.of(pageNo,pageSize),id);
    }

    @Override
    public Ewallet findByLoginID(int id) {
        return eWalletRepo.findEwalletByLoginId3(id);
    }

    @Override
    public Ewallet replenish(int ewalletId, int amount) {
         Ewallet ewallet = this.findById(ewalletId);
         double oldAmount = ewallet.getAmount();
         ewallet.setAmount(oldAmount+amount);
        return eWalletRepo.save(ewallet);
    }

    @Override
    public int getSize(){
        return (int)eWalletRepo.count();
    }

    @Override
    public int getSizeByLoginId(int id) {
        return eWalletRepo.countEwalletByLoginId3(id);
    }


}
