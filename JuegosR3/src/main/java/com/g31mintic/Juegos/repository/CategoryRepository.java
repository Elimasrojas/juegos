
package com.g31mintic.Juegos.repository;

import com.g31mintic.Juegos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<Category, Long>{
    
    
}
