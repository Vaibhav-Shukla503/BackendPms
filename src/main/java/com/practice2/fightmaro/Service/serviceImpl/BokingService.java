package com.practice2.fightmaro.Service.serviceImpl;

import com.practice2.fightmaro.Entities.Booking;
import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.BookingDto;
import com.practice2.fightmaro.Payloads.PropertyDto;
import com.practice2.fightmaro.Repositories.BookingRepo;
import com.practice2.fightmaro.Repositories.PropertyRepo;
import com.practice2.fightmaro.Repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BokingService {

    @Autowired private PropertyRepo propertyRepo;
    @Autowired private UserRepo userRepo;
    @Autowired private BookingRepo bookingRepo;
    @Autowired
    private ModelMapper modelMapper;

    public Booking createBooking(int propertyId, int buyerId) {
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        User buyer = userRepo.findById(buyerId)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));
        User seller = property.getOwner();

        Booking booking = new Booking();
        booking.setProperty(property);
        booking.setBuyer(buyer);
        booking.setSeller(seller); // Set owning side (important)

        return bookingRepo.save(booking); // This is enough
    }

    public List<BookingDto> getBookingsBySeller(int sellerId) {
        List<Booking> bookings= bookingRepo.findBySellerId(sellerId);
        List<BookingDto> propertyDtos=bookings.stream().map(p->this.modelMapper.map(p,BookingDto.class)).collect(Collectors.toList());
        return propertyDtos;
    }

    public List<BookingDto> getBookingsByBuyer(int buyerId) {
        return bookingRepo.findByBuyerId(buyerId);
    }


    public Booking confirmBooking(int bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("CONFIRMED");
        return bookingRepo.save(booking);
    }
    }



