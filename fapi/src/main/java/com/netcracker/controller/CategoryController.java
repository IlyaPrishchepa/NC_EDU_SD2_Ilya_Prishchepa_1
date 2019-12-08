package com.netcracker.controller;

import com.netcracker.models.Category;
import com.netcracker.services.implementation.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping
    public Category add(@RequestBody Category category){
        return categoryService.add(category);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.deleteByID(id);
    }

    @GetMapping
    public List<Category> getAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return categoryService.findAll(pageNo-1,pageSize);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @GetMapping("/size")
    public int getSize() {
        return categoryService.getSize(); }

}
