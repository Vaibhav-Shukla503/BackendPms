package com.practice2.fightmaro.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Data
@Table(name = "Bookings of Users")
    public class Booking {
        @Id
        @GeneratedValue
        private int id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonManagedReference
        private User buyer;

        @ManyToOne
        @JoinColumn(name="property_id")
        @JsonManagedReference
        private Property property;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonManagedReference
    private User seller;

        private String status = "PENDING"; // or APPROVED, REJECTED
        private LocalDate requestDate=LocalDate.now();
        private LocalTime requestTime=LocalTime.now();
    }


