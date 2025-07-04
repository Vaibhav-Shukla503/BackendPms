package com.practice2.fightmaro.Repositories;

import com.practice2.fightmaro.Entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatEntity,Integer> {
    List<ChatEntity> findBySenderAndReceiver(String sender, String receiver);
    List<ChatEntity> findByReceiverAndSender(String receiver, String sender);
}