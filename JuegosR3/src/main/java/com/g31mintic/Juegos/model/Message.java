
package com.g31mintic.Juegos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)   
    @Column(name = "idmessage")
    private Long idMessage;

    @Column(name = "messagetext",nullable = false,length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "gameid")
    @JsonIgnoreProperties({"messages","reservations"})
    private Game game;

    @ManyToOne
    @JoinColumn(name = "clientid")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;


}
