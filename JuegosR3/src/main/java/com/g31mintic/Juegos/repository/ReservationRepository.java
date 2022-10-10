package com.g31mintic.Juegos.repository;

import com.g31mintic.Juegos.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}
