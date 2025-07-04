package com.practice2.fightmaro.Controllers;


import com.practice2.fightmaro.Entities.ChatEntity;
import com.practice2.fightmaro.Service.serviceImpl.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private ChatService messageService;

    @GetMapping("/messages")
    public ResponseEntity<List<ChatEntity>> getMessages(
            @RequestParam String user1,
            @RequestParam String user2) {
        return ResponseEntity.ok(messageService.getChat(user1, user2));
    }
}
