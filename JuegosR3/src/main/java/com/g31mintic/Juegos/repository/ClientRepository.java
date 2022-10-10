
package com.g31mintic.Juegos.repository;

import com.g31mintic.Juegos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
