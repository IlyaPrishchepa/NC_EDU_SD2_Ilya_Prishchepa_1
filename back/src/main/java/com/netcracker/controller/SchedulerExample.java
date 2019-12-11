package com.netcracker.controller;

import com.netcracker.entity.Company;
import com.netcracker.entity.Ewallet;
import com.netcracker.entity.Services;
import com.netcracker.entity.Subscription;
import com.netcracker.services.implementation.CompanyServiceImpl;
import com.netcracker.services.implementation.EWalletServiceImpl;
import com.netcracker.services.implementation.SubscriptionServiceImpl;
import com.netcracker.services.implementation.UserServiceImpl;
import com.netcracker.services.interfaces.CompanyService;
import com.netcracker.services.interfaces.EWalletService;
import com.netcracker.services.interfaces.SubscriptionService;
import com.netcracker.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerExample {

    @Autowired
    private SubscriptionServiceImpl subscriptionService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private EWalletServiceImpl eWalletService;

    @Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentData() {
        this.transaction();
    }


    public void transaction() {
        int size = subscriptionService.getSize();
        Subscription subscription;
        double price;
        int companyId,companyLoginId,companyEwalletId ;
        double userAmount,companyAmount;

        for(int i = 0; i < size; i++){
            subscription = subscriptionService.findAll(i, 1).get(0);
            if(subscription.isStatus() == true) {
                price = subscription.getServicesId().getPrice();
                int userEwalletId = subscription.getEwalletId();
                userAmount = eWalletService.findById(userEwalletId).getAmount();
                companyId = subscription.getServicesId().getCompanyId();
                companyLoginId = companyService.findById(companyId).getLoginId2().getId();
                companyEwalletId = eWalletService.findByLoginID(companyLoginId).getId();
                companyAmount = eWalletService.findById(companyEwalletId).getAmount();
                if (userAmount > 0) {
                    eWalletService.updateAmountById(userEwalletId, userAmount - price);
                    eWalletService.updateAmountById(companyEwalletId, companyAmount + price);
                }else{
                    subscriptionService.updateStatusById(subscription.getId(),false);
                }
            }
        }



    }
}

        /*int size = subscriptionService.getSize();
        Subscription subscription = new Subscription();
        Company company = new Company();
        double price, amountUser,amountCompany;
        int companyLoginId,eWalletIdOfUser;

        int companyId;
        for(int i = 0;i<size;i++){
            subscription = subscriptionService.findAll(i,1).get(0);
            price = subscription.getServicesId().getPrice();
            companyId = subscription.getServicesId().getCompanyId();
            company = companyService.findById(companyId);
            companyLoginId = company.getLoginId2().getId();
            eWalletIdOfUser = subscription.getEwalletId();
            Ewallet ewalletuser = eWalletService.findById(eWalletIdOfUser);
            if (ewalletuser == null) {
                System.out.println(eWalletIdOfUser);
            }
            List<Ewallet> ewalletListOfCompany = eWalletService.findByLoginID(companyLoginId);
            System.out.println(ewalletListOfCompany.toString());
           // amountCompany = eWalletService.findById(companyLoginId).getAmount();
*//*            if(amountUser > 0){
                eWalletService.updateAmountById(eWalletIdOfUser,amountUser-price);
                eWalletService.updateAmountById(companyId,amountCompany+price);
            }*/
