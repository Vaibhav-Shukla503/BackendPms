package com.practice2.fightmaro.Repositories;

import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.PropertyDto;
import com.practice2.fightmaro.Payloads.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepo extends JpaRepository<Property,Integer> {
    List<Property> findByOwner(User owner);


}
