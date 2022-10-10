package com.g31mintic.Juegos.service;

import com.g31mintic.Juegos.model.Category;
import com.g31mintic.Juegos.model.Reservation;
import com.g31mintic.Juegos.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
             Optional<Reservation> e=reservationRepository.findById(reservation.getIdReservation());
             if(e.isPresent()){
                 return e.get();
             }else{
                 return reservationRepository.save(reservation);
             }
        }
    }
    
    
    
}
