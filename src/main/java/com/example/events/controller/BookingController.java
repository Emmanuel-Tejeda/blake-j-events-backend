package com.example.events.controller;


import com.example.events.model.BookingModel;
import com.example.events.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

  /**
   * Adds a new client into the database
   * 
   * @param sid - The id of the booking we are looking for
   * @return The booking if found in the database
   * @StatusCode Returns a 200 status code connection established
   */
    @GetMapping("event/booking/{id}")
    public BookingModel getBookingById(@PathVariable("id") Long sid){

        return bookingService.getBookingById(sid);
    }

    /**
     * Returns all the bookings in database
     * 
     * @return All the bookings as a list of type BookingModel
     * @StatusCode Returns a 200 status code connection established
     */
    @GetMapping("event/bookings")
    public List<BookingModel> getBookings(){
      return bookingService.getBookings();
    }

    /**
     * 
     * @param newBooking - New booking to be added to the database
     * @return The new booking if added to the database succesfully
     * @StatusCode Returns a status code of 201 object created
     */
    @PostMapping("event/booking")
    public ResponseEntity<BookingModel> addBooking(@Valid @RequestBody BookingModel newBooking){
        bookingService.saveBooking(newBooking);
        return new ResponseEntity<BookingModel>(newBooking, HttpStatus.CREATED);
    }

    /**
     *
     * @param newBooking The booking that the user updated
     * @param id The id of the booking that requires an update
     * @return The updated booking
     * @StatusCode 200 Ok
     */
    @PutMapping("event/booking/{id}")
    public ResponseEntity<BookingModel> updateBooking(@Valid @RequestBody BookingModel newBooking, @PathVariable Long id){

        bookingService.updateBooking(newBooking, id);
        return ResponseEntity.ok(newBooking);
    }

    
}
