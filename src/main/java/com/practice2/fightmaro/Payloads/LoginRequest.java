package com.practice2.fightmaro.Payloads;

import lombok.Data;

@Data
public class LoginRequest {
    String username;
    String password;
}
