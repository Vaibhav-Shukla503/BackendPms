package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Entities.Booking;
import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.BookingDto;
import com.practice2.fightmaro.Repositories.BookingRepo;
import com.practice2.fightmaro.Repositories.PropertyRepo;
import com.practice2.fightmaro.Repositories.UserRepo;
import com.practice2.fightmaro.Service.serviceImpl.BokingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking/api")
public class BookingController {

    @Autowired private BokingService bookingService;

    @GetMapping("/test")
    public ResponseEntity<String> testAuth() {
        return ResponseEntity.ok("Token is working, you're authenticated!");
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(
            @RequestParam int propertyId,
            @RequestParam int buyerId) {
        Booking booking = bookingService.createBooking(propertyId, buyerId);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<BookingDto>> getBookingsBySeller(@PathVariable int sellerId) {
        return ResponseEntity.ok(bookingService.getBookingsBySeller(sellerId));
    }

    @GetMapping("/buyer/{buyerId}")
    public ResponseEntity<List<BookingDto>> getBookingsByBuyer(@PathVariable int buyerId) {
        return ResponseEntity.ok(bookingService.getBookingsByBuyer(buyerId));
    }
    @PutMapping("/{id}/confirm")
    public ResponseEntity<?> confirmBooking(@PathVariable int  id) {
        Booking updatedBooking = bookingService.confirmBooking(id);
        return ResponseEntity.ok("Your booking is confirmed");
    }
}
