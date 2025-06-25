package com.practice2.fightmaro.Payloads;

import lombok.Data;

@Data
public class LoginResponse {
    String username;
    String jwtToken;

    public LoginResponse(String username, String jwtToken) {
        this.username = username;
        this.jwtToken = jwtToken;
    }
}
