package com.practice2.fightmaro.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    private int id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;
}
