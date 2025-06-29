package com.practice2.fightmaro.Service;

import com.practice2.fightmaro.Entities.ChatEntity;
import com.practice2.fightmaro.Payloads.ChatMessage;
import com.practice2.fightmaro.Repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
    @Autowired
    private ChatRepository chatRepo;

    public void saveMessage(ChatMessage message) {
        ChatEntity entity = new ChatEntity();
        entity.setSender(message.getSender());
        entity.setReceiver(message.getReceiver());
        entity.setContent(message.getContent());
        entity.setTimestamp(LocalDateTime.now());
        chatRepo.save(entity);
    }
}
