package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Payloads.ChatMessage;
import com.practice2.fightmaro.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/sendMessage") // client → server
    @SendTo("/topic/public")        // server → all clients
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        message.setTimestamp(LocalDateTime.now().toString());
        messageService.saveMessage(message);
        return message;
    }
}
