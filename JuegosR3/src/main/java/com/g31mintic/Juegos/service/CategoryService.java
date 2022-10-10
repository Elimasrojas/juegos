
package com.g31mintic.Juegos.service;

import com.g31mintic.Juegos.model.Category;
import com.g31mintic.Juegos.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    
    public Category getFarmById(Long id){
        return categoryRepository.findById(id).get();
    }
    
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
             Optional<Category> e=categoryRepository.findById(category.getId());
             if(e.isPresent()){
                 return e.get();
             }else{
                 return categoryRepository.save(category);
             }
        }
    }
    
    public void deleteCategory(Long id){
       categoryRepository.deleteById(id);               
    }
    
    public Category updateCategory(Category category){
        //la finca existe
        if (category.getId()!=null){
            //validamos si la finca existe
            Optional<Category> opcional =  categoryRepository.findById(category.getId());
            
            //la finca no existe
            if (opcional.isEmpty()) return category;
            //si la finca existe
            else{
               Category categoryDB = opcional.get();               
               categoryDB.setName(category.getName());
               categoryDB.setDescription(category.getDescription());
               return categoryRepository.save(categoryDB);
            }            
        }
        return category;
    }
    
    
    
    
}
