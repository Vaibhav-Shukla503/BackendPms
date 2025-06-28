package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Entities.Booking;
import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.BookingDto;
import com.practice2.fightmaro.Repositories.BookingRepo;
import com.practice2.fightmaro.Repositories.PropertyRepo;
import com.practice2.fightmaro.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    PropertyRepo propertyRepo;
    @PostMapping("/api/bookings")
    public ResponseEntity<?> createBooking(@RequestBody BookingDto dto) {
        // Validate buyer
        User buyer = userRepo.findById(dto.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found with ID: " + dto.getBuyerId()));

        // Validate property
        Property property = propertyRepo.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found with ID: " + dto.getPropertyId()));

        User seller = property.getOwner();

        Booking booking = new Booking();
        booking.setBuyer(buyer);
        booking.setProperty(property);
        booking.setSeller(seller);
        booking.setRequestDate(LocalDateTime.now());

        bookingRepo.save(booking);
        return ResponseEntity.ok("Booking requested!");
    }

    @PutMapping("/bookings/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable int  id, @RequestParam String status) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        booking.setStatus(status);
        bookingRepo.save(booking);
        return ResponseEntity.ok("Status updated");
    }


}
