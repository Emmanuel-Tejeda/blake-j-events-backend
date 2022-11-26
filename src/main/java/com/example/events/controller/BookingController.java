package com.example.events.controller;


import com.example.events.dao.BookingJpa;
import com.example.events.model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class BookingController {

    @Autowired
    BookingJpa bookingJpa;


    @GetMapping("event/booking/{id}")
    public Optional<BookingModel> getBookingById(@PathVariable("id") Long sid){
      return bookingJpa.findById(sid);
    }

    @PostMapping("event/booking")
    public Optional<BookingModel> addBooking(@RequestBody BookingModel newbooking){
        bookingJpa.save(newbooking);
        return bookingJpa.findById(newbooking.getBookingId());
    }
}
