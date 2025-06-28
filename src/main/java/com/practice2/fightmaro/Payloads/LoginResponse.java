package com.practice2.fightmaro.Payloads;

import lombok.Data;

@Data
public class LoginResponse {
    UserDto userDto;
    String jwtToken;

    public LoginResponse(UserDto user, String jwtToken) {
        this.userDto = user;
        this.jwtToken = jwtToken;
    }
}
