package com.g31mintic.Juegos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "score")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idscore")
    private Integer idScore;
    @Column(name = "messagetext")
    private String messageText;
    @Column(name = "starts")
    private Integer stars;
    
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    
}
