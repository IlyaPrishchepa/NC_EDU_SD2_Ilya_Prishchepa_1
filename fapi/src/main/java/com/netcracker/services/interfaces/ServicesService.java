package com.netcracker.services.interfaces;

import com.netcracker.models.Services;

import java.util.List;

public interface ServicesService {
    Services add(Services services);
    void delete(int id);
    List<Services> findAll(int pageNo, int pageSize);
    List<Services> findByCompanyId(int page, int size,int id);
    Services findByName(String name);
    Services findById(int id);
    int getSize();
}
