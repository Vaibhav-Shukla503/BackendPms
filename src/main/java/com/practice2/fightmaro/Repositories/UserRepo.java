package com.practice2.fightmaro.Repositories;

import com.practice2.fightmaro.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
