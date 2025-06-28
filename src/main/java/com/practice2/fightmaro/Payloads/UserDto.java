package com.practice2.fightmaro.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.SQLInsert;

@Data
public class UserDto {

    private int id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min=6)
    private String password;
    @NotBlank
    private String mobno;

    @NotBlank
    private String address;
    private byte[] image;
}
