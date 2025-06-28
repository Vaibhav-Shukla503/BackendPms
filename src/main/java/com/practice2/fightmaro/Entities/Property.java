package com.practice2.fightmaro.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity

@Data
@Table(name="Propertyhbhai")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String price;
    private String type;
    private String address;
    private Integer bedrooms;
    private Integer bathrooms;
    private Double area;

   @ManyToOne
    @JoinColumn(name="propertyowner")
   @JsonManagedReference
    private User owner;

}
