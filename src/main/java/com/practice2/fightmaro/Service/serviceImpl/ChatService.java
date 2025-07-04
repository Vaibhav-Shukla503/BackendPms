package com.practice2.fightmaro.Service.serviceImpl;

import com.practice2.fightmaro.Entities.ChatEntity;
import com.practice2.fightmaro.Payloads.ChatMessage;
import com.practice2.fightmaro.Repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class ChatService {

    @Autowired
    private ChatRepository messageRepository;

    public void saveMessage(ChatMessage chatMessage) {
        ChatEntity message = new ChatEntity();
        message.setSender(chatMessage.getSender());
        message.setReceiver(chatMessage.getReceiver());
        message.setContent(chatMessage.getContent());
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }

    public List<ChatEntity> getChat(String user1, String user2) {
        List<ChatEntity> m1 = messageRepository.findBySenderAndReceiver(user1, user2);
        List<ChatEntity> m2 = messageRepository.findBySenderAndReceiver(user2,user1);
        List<ChatEntity> all = new ArrayList<>();
        all.addAll(m1);
        all.addAll(m2);
        all.sort(Comparator.comparing(ChatEntity::getTimestamp));
        return all;
    }
}
