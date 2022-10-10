
package com.g31mintic.Juegos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "idclient")
    private Long idClient;

    @Column(name= "email", nullable = false, length = 45)
    private String email;
    
    @Column(name = "password",nullable = false,length = 250)
    private String password;
   
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "age", nullable = true)
    private Integer age;

    

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
}
