package com.netcracker.services.implementation;

import com.netcracker.entity.Category;
import com.netcracker.repository.CategoryRepo;
import com.netcracker.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;

  @Override
  public Category add(Category category) {
    return categoryRepo.save(category);
  }

  @Override
  public void deleteByID(int id) {
      categoryRepo.deleteById(id);
  }

  @Override
  public List<Category> findAll() {
    return (List<Category>) categoryRepo.findAll();
  }

  @Override
  public Category findById(int id) {
    return categoryRepo.findById(id).get();
  }
}
