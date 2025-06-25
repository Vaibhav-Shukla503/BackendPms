package com.practice2.fightmaro.Payloads;

import com.practice2.fightmaro.Entities.User;
import lombok.Data;

@Data
public class PropertyDto {

    private int id;
    private String type;
    private String address;
    private Integer bedrooms;
    private Integer bathrooms;
    private Double area;
     private UserDto owner;
}
