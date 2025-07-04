package com.practice2.fightmaro.Payloads;

import com.practice2.fightmaro.Entities.Booking;
import com.practice2.fightmaro.Entities.Role;
import com.practice2.fightmaro.Entities.Roleh;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.SQLInsert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class UserDto {

    private int id;

    private String name;
    @Email
    private String email;

    @Size(min=6)
    private String password;

    private String mobno;


    private String address;
    private byte[] image;
    private Roleh role;
    private Set<Role> roles;

}
