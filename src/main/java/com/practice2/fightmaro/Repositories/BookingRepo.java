package com.practice2.fightmaro.Repositories;

import com.practice2.fightmaro.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

    List<Booking> findBySellerId(Long sellerId);
}
