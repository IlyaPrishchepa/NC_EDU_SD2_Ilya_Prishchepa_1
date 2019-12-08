package com.netcracker.services.implementation;

import com.netcracker.models.Ewallet;
import com.netcracker.property.BackendApiProperties;
import com.netcracker.services.interfaces.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EWalletServiceImpl implements EWalletService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public EWalletServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Ewallet save(Ewallet ewallet) {
        return restTemplate.postForObject(backendApiProperties.getEWalletUri(),ewallet,Ewallet.class);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(backendApiProperties.getEWalletUri() + "/" + id);
    }


    @Override
    public Ewallet findById(int id) {
        return restTemplate.getForObject(backendApiProperties.getEWalletUri()
                +"/find-by-id/" + id, Ewallet.class);
    }

    @Override
    public List<Ewallet> findByLoginID(int pageNo, int pageSize, int id) {
        return Arrays.asList(restTemplate.getForObject(backendApiProperties.getEWalletUri()
                +"/find-by-loginId?pageNo="+pageNo+"&pageSize="+pageSize+"&id="+id, Ewallet[].class));
    }

    @Override
    public Ewallet replenish(int ewalletId, int amount) {
        return restTemplate.getForObject(backendApiProperties.getEWalletUri()
                +"/?ewalletId="+ ewalletId + "&amount=" + amount, Ewallet.class);
    }

    @Override
    public int getSize(){
        return restTemplate.getForObject(backendApiProperties.getEWalletUri()+"/size", Integer.class);
    }
}
