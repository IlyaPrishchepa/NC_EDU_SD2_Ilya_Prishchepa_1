package com.netcracker.services.implementation;


import com.netcracker.entity.Services;
import com.netcracker.repository.ServicesRepo;
import com.netcracker.services.interfaces.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServicesRepo servicesRepo;

    @Override
    public Services add(Services services) {
        return servicesRepo.save(services);
    }

    @Override
    public void delete(int id) {
        servicesRepo.existsById(id);
    }

    @Override
    public List<Services> findAll(int pageNo, int pageSize) {
        return servicesRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }

    @Override
    public Services findByName(String name) {
        return servicesRepo.findByName(name);
    }

    @Override
    public Services findById(int id) {
        return servicesRepo.findById(id).get();
    }

    @Override
    public int getSize(){
        return (int)servicesRepo.count();
    }


}
