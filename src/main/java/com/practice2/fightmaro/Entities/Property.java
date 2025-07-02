package com.practice2.fightmaro.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
   @OneToMany(mappedBy = "property")
   @JsonIgnore
    private List<Booking> bookings=new ArrayList<>();

}
