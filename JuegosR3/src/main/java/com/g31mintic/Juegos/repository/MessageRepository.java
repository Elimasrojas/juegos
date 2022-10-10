package com.g31mintic.Juegos.repository;

import com.g31mintic.Juegos.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MessageRepository  extends JpaRepository<Message, Long>{
    
}
