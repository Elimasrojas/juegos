
package com.g31mintic.Juegos.repository;

import com.g31mintic.Juegos.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface GameRepository  extends JpaRepository<Game, Long>{
    
    
}

