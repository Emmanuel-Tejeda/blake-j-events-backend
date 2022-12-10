package com.example.events.controller;


import com.example.events.dao.BookingJpa;
import com.example.events.model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class BookingController {

    @Autowired
    BookingJpa bookingJpa;

  /**
   * Adds a new client into the database
   * 
   * @param sid - The id of the booking we are looking for
   * @return The booking if found in the database
   */
    @GetMapping("event/booking/{id}")
    public Optional<BookingModel> getBookingById(@PathVariable("id") Long sid){
      return bookingJpa.findById(sid);
    }

    /**
     * Returns all the bookings in database
     * 
     * @return All the bookings as a list of type BookingModel
     */
    @GetMapping("event/booking")
    public List<BookingModel> getBookings(){
      return bookingJpa.findAll();
    }

    /**
     * 
     * @param newBooking - New booking to be added to the database
     * @return The new booking if added to the database succesfully
     */
    @PostMapping("event/booking")
    public Optional<BookingModel> addBooking(@RequestBody BookingModel newBooking){
        bookingJpa.save(newBooking);
        return bookingJpa.findById(newBooking.getBookingId());
    }

    
}
