package com.practice2.fightmaro.Repositories;

import com.practice2.fightmaro.Entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatEntity,Long> {
}