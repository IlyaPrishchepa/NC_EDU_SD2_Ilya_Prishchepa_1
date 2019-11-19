package com.netcracker.services.interfaces;

import com.netcracker.entity.Category;

import java.util.List;

public interface CategoryService {

  Category add (Category category);
  void deleteByID(int id);
  List<Category> findAll();
  Category findById(int id);

}
