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
    * @param id - The id of the booking we are looking for
    * @return The booking if found in the database
    * @StatusCode Returns a 200 status code connection established
    */
    @GetMapping("event/booking/{id}")
    public ResponseEntity<BookingModel> getBookingById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<BookingModel>(bookingService.getBookingById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<BookingModel>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Returns all the bookings in database
     *
     * @return All the bookings as a list of type BookingModel
     * @StatusCode 200 Ok | 404 Not Found
     */
    @GetMapping("event/booking")
    public ResponseEntity<List> getBookings () {

        try {
            return new ResponseEntity<>(bookingService.getBookings(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param newBooking - New booking to be added to the database
     * @return The new booking if added to the database succesfully
     * @StatusCode 201 Created || 400 Bad Request
     */
    @PostMapping("event/booking")
    public ResponseEntity<BookingModel> addBooking (@Valid @RequestBody BookingModel newBooking){

        try {
            bookingService.saveBooking(newBooking);
            return new ResponseEntity<BookingModel>(newBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<BookingModel>(newBooking, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * @param newBooking The booking that the user updated
     * @param id The id of the booking that requires an update
     * @return Response Entity
     * @StatusCode 200 Updated || 204 Not Found
     */
    @PutMapping("event/booking/{id}")
    public ResponseEntity<BookingModel> updateBooking (@Valid @RequestBody BookingModel
    newBooking, @PathVariable Long id){

        try {
            bookingService.updateBooking(newBooking, id);
            return new ResponseEntity<BookingModel>(newBooking, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<BookingModel>(HttpStatus.NO_CONTENT);
        }
    }


    /**
     *
     * @param id of BookingModel to be deleted
     * @return Status code
     * @StatusCode 204 No Content || 404 Not Found
     */
    @DeleteMapping("event/booking/{id}")
    public ResponseEntity<BookingModel> deleteBooking (@PathVariable Long id) throws Exception {

        try {
            bookingService.deleteBooking(id);
            return new ResponseEntity<BookingModel>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
