package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Payloads.ChatMessage;
import com.practice2.fightmaro.Service.MessageService;
import com.practice2.fightmaro.Service.serviceImpl.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private ChatService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage message, Principal principal) {
        message.setTimestamp(LocalDateTime.now().toString());
        messageService.saveMessage(message);
        messagingTemplate.convertAndSendToUser(
                message.getReceiver(), "/queue/messages", message
        );
        System.out.println("Sender: " + message.getSender());
        System.out.println("Receiver: " + message.getReceiver());
        System.out.println("Sending to user destination: /user/" + message.getReceiver() + "/queue/messages");

    }

}

