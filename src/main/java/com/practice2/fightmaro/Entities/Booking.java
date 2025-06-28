package com.practice2.fightmaro.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
    public class Booking {
        @Id
        @GeneratedValue
        private Long id;

        @ManyToOne
        private User buyer;

        @ManyToOne
        private Property property;

        @ManyToOne
        private User seller;

        private String status = "PENDING"; // or APPROVED, REJECTED
        private LocalDateTime requestDate;
    }


