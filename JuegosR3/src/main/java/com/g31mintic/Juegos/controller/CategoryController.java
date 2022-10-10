package com.g31mintic.Juegos.controller;

import com.g31mintic.Juegos.model.Category;

import com.g31mintic.Juegos.service.CategoryService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //http://localhost:8084/api/Category/all
    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getFarmById(@PathVariable("id") Long id){
        return categoryService.getFarmById(id);
    }
    
    //http://localhost:8084/api/Category/save
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category) { 
         categoryService.save(category);
         return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
       categoryService.updateCategory(category);
       return ResponseEntity.status(201).build(); 
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFarm(@PathVariable("id") Long id){
       categoryService.deleteCategory(id);
       return ResponseEntity.status(204).build();
    }
}
