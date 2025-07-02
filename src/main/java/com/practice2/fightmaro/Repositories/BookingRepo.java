package com.practice2.fightmaro.Repositories;

import com.practice2.fightmaro.Entities.Booking;
import com.practice2.fightmaro.Payloads.BookingDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findBySellerId(int sellerId); // For seller dashboard
    List<BookingDto> findByBuyerId(int buyerId);

}
