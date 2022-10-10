package com.g31mintic.Juegos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name",  nullable = false,length = 45)
    private String name;
    
    @Column(name = "developer",nullable = false, length = 45)
    private String developer;
    
    @Column(name = "year",nullable = false)
    private Integer year;
    
    @Column(name = "description", nullable = false, length = 250)
    private String description;  
    
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("games")
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "game")
    @JsonIgnoreProperties({"game","client"})
    private List<Message> messages; 
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "game")
    @JsonIgnoreProperties("game")
    List<Reservation> reservations; 
    
    
    
}
