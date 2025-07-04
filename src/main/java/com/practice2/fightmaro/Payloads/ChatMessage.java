package com.practice2.fightmaro.Payloads;

import lombok.Data;

@Data
public class ChatMessage {
    private int id;
    private String sender;
    private String receiver;
    private String content;
    private String timestamp;
}

