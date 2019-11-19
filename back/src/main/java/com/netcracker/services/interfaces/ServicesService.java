package com.netcracker.services.interfaces;

import com.netcracker.entity.Services;

import java.util.List;

public interface ServicesService {
    Services add(Services services);
    void delete(int id);
    List<Services> findAll(int page, int size);
    Services findByName(String name);
    Services findById(int id);
}
