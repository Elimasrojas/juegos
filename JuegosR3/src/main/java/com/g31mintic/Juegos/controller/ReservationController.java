package com.g31mintic.Juegos.controller;

import com.g31mintic.Juegos.model.Message;
import com.g31mintic.Juegos.model.Reservation;
import com.g31mintic.Juegos.service.MessageService;
import com.g31mintic.Juegos.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    //http://localhost:8085/api/Reservation/all
    @GetMapping("/all")
    public List<Reservation> getAllMessages(){
        return reservationService.getAll();
    }

    //http://localhost:8085/api/Reservation/save
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
        return ResponseEntity.status(201).build();
    }
    
}
