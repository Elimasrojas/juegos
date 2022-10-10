
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;


@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    
    @Column(name = "description",  length = 250)
    private String description;
        
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Game> games;      

}