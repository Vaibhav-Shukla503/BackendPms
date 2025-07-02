package com.practice2.fightmaro.Payloads;

import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Entities.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDto {

    int id;
    private UserDto buyer;
    private PropertyDto  property;
    private LocalDate localDate=LocalDate.now();
    private LocalTime time=LocalTime.now();
    private String status = "PENDING";
}
