package com.g31mintic.Juegos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "idreservation")
    private Long idReservation;

    @Column(name = "startdate" )
    private Date startDate;

    @Column(name = "devolutiondate")
    private Date devolutionDate;
    
    @Column(name = "status")
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name = "gameid")
    @JsonIgnoreProperties("reservations")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "clientid")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
}
